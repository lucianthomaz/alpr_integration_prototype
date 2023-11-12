FROM eclipse-temurin:17-jdk-alpine

WORKDIR /usr/local/app
COPY application/build/libs/application-0.0.1-SNAPSHOT.jar /usr/local/app/application-0.0.1-SNAPSHOT.jar
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/app/application-0.0.1-SNAPSHOT.jar"]