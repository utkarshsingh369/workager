#!/bin/sh

set -eu

SCRIPT_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
PROJECT_ROOT=$(CDPATH= cd -- "$SCRIPT_DIR/.." && pwd)

if ! command -v mvn >/dev/null 2>&1; then
    echo "Error: Maven (mvn) is required but was not found in PATH." >&2
    exit 1
fi

if ! command -v osascript >/dev/null 2>&1; then
    echo "Error: this launcher requires macOS and the osascript command." >&2
    exit 1
fi

cd "$PROJECT_ROOT"
echo "Building all Maven modules from $PROJECT_ROOT..."
mvn clean install

osascript - "$PROJECT_ROOT" <<'APPLESCRIPT'
on run argv
    set projectRoot to item 1 of argv
    set serviceDirectories to {projectRoot & "/app/auth-service", projectRoot & "/app/user-service"}

    tell application "Terminal"
        activate
        repeat with serviceDirectory in serviceDirectories
            set servicePath to contents of serviceDirectory
            do script "cd " & quoted form of servicePath & " && mvn spring-boot:run"
        end repeat
    end tell
end run
APPLESCRIPT
