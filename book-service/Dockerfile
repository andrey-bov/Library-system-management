FROM openjdk:8-jdk-alpine
EXPOSE 8082
COPY build/libs/book-service-1.0-SNAPSHOT.jar .
RUN apk add --no-cache bash
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh
ENTRYPOINT ["/wait-for.sh", "user-service:8081", "--timeout=90", "--", "java", "-jar", "book-service-1.0-SNAPSHOT.jar"]