FROM openjdk:21-jdk-slim
RUN java -version
WORKDIR /app
COPY /target/techshop-0.0.1-SNAPSHOT.jar /app/techshop.jar
CMD ["java", "-jar", "/app/techshop.jar"]
