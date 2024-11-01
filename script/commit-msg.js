#!/usr/bin/env node

const fs = require('fs');

const commitMsgPath = process.argv[2];

// Read the commit message
let commitMsg;
try {
  commitMsg = fs.readFileSync(commitMsgPath, 'utf-8').trim();
} catch (error) {
  console.error('❌ Error reading commit message file:', error);
  process.exit(1);
}

// Start with prefix [feat, setup, test, fix, version]
const prefixPattern = /^(feat|setup|test|fix|version)/;
if (!prefixPattern.test(commitMsg)) {
  console.error('❌ The commit message must start with one of the following prefixes: feat, setup, test, fix, version.');
  printAllErrors();
}

// After prefix, in parentheses, package name
const packagePattern = /^(feat|setup|test|fix|version)\(([a-zA-Z0-9_-]+)\)/;
const packageMatch = commitMsg.match(packagePattern);
if (!packageMatch) {
  console.error('❌ After the prefix, the commit message must include a package name in parentheses. Example: feat(auth).');
  printAllErrors();
}

// Have a colon after the package name
const colonPattern = /^(feat|setup|test|fix|version)\([a-zA-Z0-9_-]+\):/;
if (!colonPattern.test(commitMsg)) {
  console.error('❌ The commit message must contain a colon ":" after the package name.');
  printAllErrors();
}

// Have a space after the colon
const spaceAfterColonPattern = /^(feat|setup|test|fix|version)\([a-zA-Z0-9_-]+\):\s/;
if (!spaceAfterColonPattern.test(commitMsg)) {
  console.error('❌ There must be a space " " after the colon in the commit message.');
  printAllErrors();
}

// Description not more than 140 characters
const descriptionPattern = /^(feat|setup|test|fix|version)\([a-zA-Z0-9_-]+\):\s(.{1,140})$/;
const descriptionMatch = commitMsg.match(descriptionPattern);
if (!descriptionMatch) {
  // Check if description is missing
  const hasDescription = /^.*:\s+.+$/.test(commitMsg);
  if (!hasDescription) {
    console.error('❌ The commit message must include a description after the colon and space.');
    printAllErrors();
  } else {
    const description = commitMsg.split(': ')[1];
    if (description && description.length > 140) {
      console.error(`❌ The description is too long (${description.length}/140). Please limit it to 140 characters.`);
      printAllErrors();
    } else {
      console.error('❌ The commit message description is invalid. Ensure it does not exceed 140 characters.');
      printAllErrors();
    }
  }
  printAllErrors();
}

console.log('✅ Commit message is valid.');
process.exit(0);

function printAllErrors(){
    console.error('\nPlease follow the commit message guidelines:\n');
    console.error('  <prefix>(<package>): <description>');
    console.error('  - prefix: feat, setup, test, fix, version');
    console.error('  - package: name of the package affected (alphanumeric, underscores, or hyphens)');
    console.error('  - description: up to 140 characters\n');
    process.exit(1);
}