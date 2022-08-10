FROM openjdk:8-jdk-alpine
LABEL maintainer="iamcontained@gmail.com"
VOLUME /tmp
ARG JAR_FILE=target/helloworld*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
