FROM openjdk:17-jdk-slim-buster

COPY . /app

WORKDIR ./app

RUN ./gradlew build

ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} ./app.jar
ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]