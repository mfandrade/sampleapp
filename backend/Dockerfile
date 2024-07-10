FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/sampleapp.jar sampleapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/sampleapp.jar"]


