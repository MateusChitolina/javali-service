FROM maven:3.8.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

COPY --from=builder /app/target/javali-service.jar javali-service.jar

CMD ["java", "-jar", "javali-service.jar", "--spring.profiles.active=prod"]

