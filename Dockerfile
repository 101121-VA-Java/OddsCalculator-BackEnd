FROM openjdk:8-jdk-alpine as build
COPY target/oddscalculator.jar  oddscalculator.jar
ENTRYPOINT ["java", "-jar", "/oddscalculator.jar"]