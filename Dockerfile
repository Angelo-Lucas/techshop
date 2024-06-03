FROM eclipse-temurin:21.0.3_9-jdk-ubi9-minimal as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM eclipse-temurin:21.0.3_9-jre-ubi9-minimal
WORKDIR /app

COPY --from=build /workspace/app/target/techshop-0.0.1-SNAPSHOT.jar /app/techshop.jar

EXPOSE 9090

CMD ["java", "-jar", "/app/techshop.jar"]
