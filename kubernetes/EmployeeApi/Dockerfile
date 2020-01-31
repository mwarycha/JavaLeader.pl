FROM openjdk:8u212-jdk-slim
LABEL maintainer="kontakt@javaleader.pl"
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/EmployeeApi-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} EmployeeApi.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/EmployeeApi.jar"]
