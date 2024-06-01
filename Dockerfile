FROM openjdk:21-jdk-slim as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=build /workspace/app/target/techshop-0.0.1-SNAPSHOT.jar /app/techshop.jar

EXPOSE 9090

CMD ["java", "-jar", "/app/techshop.jar"]
