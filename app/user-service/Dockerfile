FROM openjdk:17
WORKDIR /app
COPY target/user-workager.jar /app/user-workager.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "/app/user-workager.jar" ]