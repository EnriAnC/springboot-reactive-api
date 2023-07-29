FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=build/libs/*.jar

WORKDIR /app

COPY gradlew /app/
COPY gradle /app/gradle
RUN chmod +x gradlew
RUN ./gradlew build

COPY ${JAR_FILE} /app/app.jar
ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]