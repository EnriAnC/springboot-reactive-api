FROM openjdk:17-jdk-slim-buster

WORKDIR /app

COPY . /app

RUN ./gradlew build

COPY build/libs/app-0.0.1-SNAPSHOT.jar ./app.jar
ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]