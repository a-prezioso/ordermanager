# Use the official Maven image as a base for the build stage
FROM maven:3.8.3-openjdk-11 as builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

COPY build.sh .

RUN chmod +x build.sh && ./build.sh

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=builder /app/target/appbackend-0.0.1-SNAPSHOT.jar /app/app.jar

COPY logback.xml logback.xml

ENTRYPOINT ["java","-Dlogging.config=logback.xml","-jar", "/app/app.jar", "--spring.config.location=classpath:/application.yaml"]