FROM openjdk:8-alpine

WORKDIR /app

COPY target/crawler.jar /app/

CMD ["java", "-jar","./crawler.jar"]