FROM maven:3.6.0-jdk-8-alpine as maven

COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN mvn clean package


FROM openjdk:8-jdk-alpine

RUN addgroup -S xyzgroup && adduser -S appuser xyzgroup

RUN mkdir orders && chown -R appuser:xyzgroup /orders

USER appuser

COPY  --from=maven target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]

LABEL version="3"
LABEL release-date="2020-11-18"

