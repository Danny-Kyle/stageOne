FROM maven:3.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21.0.6_7-jre-ubi9-minimal
COPY --from=build /target/*.jar demo.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]
