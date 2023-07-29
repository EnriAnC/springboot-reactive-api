FROM openjdk:17-jdk-slim-buster

WORKDIR /app

COPY gradlew /app/

# Copiar el contenido del proyecto (excepto la carpeta build)
COPY . /app
RUN ./gradlew bootJar

ENV TZ="America/Santiago"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/build/libs/blog-codea-bkn-0.0.1-SNAPSHOT.jar"]
