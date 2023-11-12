FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /app
COPY . .
RUN ./gradlew build

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /usr/local/app
COPY --from=builder /app/build/libs/application-0.0.1-SNAPSHOT.jar /usr/local/app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/app/application.jar"]
