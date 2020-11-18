FROM maven:3.6.0-jdk-8-alpine as maven

COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN mvn clean package


FROM openjdk:8-jdk-alpine

COPY  --from=maven target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]

LABEL version="3"
LABEL release-date="2020-11-18"

# Create a user group 'xyzgroup'
#RUN addgroup -S xyzgroup

# Create a user 'appuser' under 'xyzgroup'
#RUN adduser -S -D -h ./app appuser xyzgroup

# Chown all the files to the app user.
#RUN chown -R appuser:xyzgroup ./orders.txt

# Switch to 'appuser'
#USER appuser
