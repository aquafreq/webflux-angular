#FROM openjdk:8-jdk-alpine
#
#ARG JAR_FILE=target/*.jar
#
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT ["java","-jar","/app.jar", "-Djava.security.egd=file:/dev/./urandom"]
#
#
##FROM openjdk:8-jdk-alpine
##VOLUME /tmp
##ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} app.jar
##ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM openjdk:11

COPY build/libs/webflux-angular-0.0.1-SNAPSHOT.jar spring-app1.jar

ENTRYPOINT ["java","-jar","/spring-app1.jar"]