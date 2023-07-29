FROM openjdk:17-jdk-slim-buster

RUN app/gradlew build

ARG JAR_FILE=app/build/libs/app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app/app.jar
ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]