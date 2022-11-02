FROM openjdk:8-jdk-alpine
EXPOSE 8001
COPY build/libs/config-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "config-1.0-SNAPSHOT.jar"]