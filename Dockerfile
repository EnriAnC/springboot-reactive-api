FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=build/libs/*.jar

WORKDIR /app
COPY ${JAR_FILE} /app/app.jar
ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]