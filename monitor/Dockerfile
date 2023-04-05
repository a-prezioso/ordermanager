FROM maven:3.8.3-openjdk-17 as builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

COPY build.sh .

RUN chmod +x build.sh && ./build.sh

# Start with the official OpenJDK image as a base for the runtime stage
FROM azul/zulu-openjdk-alpine:17-jre

WORKDIR /app

COPY --from=builder /app/target/monitor-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-jar", "/app/app.jar", "--spring.config.location=classpath:/application.yaml"]