FROM openjdk:17-jdk-slim-buster

WORKDIR /app

RUN ./gradlew build

COPY build/libs/blog-codea-bkn-0.0.1-SNAPSHOT.jar /app/app.jar
ENV TZ="America/Santiago"
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]