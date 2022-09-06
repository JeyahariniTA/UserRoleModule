FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} userrolemodule.jar
ENTRYPOINT ["java","-jar","/userrolemodule.jar"]