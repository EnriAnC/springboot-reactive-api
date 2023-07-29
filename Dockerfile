FROM openjdk:17-jdk-slim-buster

WORKDIR /app

COPY . /app

RUN chmod +x gradlew
RUN ./gradlew build

ARG JAR_FILE="build/libs/*.jar"
COPY ${JAR_FILE} /app/app.jar
ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]