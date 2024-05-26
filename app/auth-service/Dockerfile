FROM openjdk:17
WORKDIR /app
COPY target/auth-workager.jar /app/auth-workager.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/app/auth-workager.jar" ]