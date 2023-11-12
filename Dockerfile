FROM docker.artifactory.us.caas.oneadp.com/innerspace/java:17-jre-temurin-onbuild

# launch jar
ENV JAVA_EXEC -jar det-gateway-1.0.3.jar
WORKDIR /usr/local/app
COPY application/build/libs/det-gateway-1.0.3.jar /usr/local/app/det-gateway-1.0.3.jar