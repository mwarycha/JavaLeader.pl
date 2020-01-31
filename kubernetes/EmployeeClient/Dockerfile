FROM openjdk:8u212-jdk-slim
LABEL maintainer="kontakt@javaleader.pl"
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/EmployeeClient-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} EmployeeClient.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/EmployeeClient.jar"]

