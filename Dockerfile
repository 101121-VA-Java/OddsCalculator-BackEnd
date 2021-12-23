FROM openjdk:8-jdk-alpine as build
COPY target/oddsCalculator.jar  oddsCalculator.jar
ENTRYPOINT ["java", "-jar", "/oddsCalculator.jar"]
EXPOSE 8080
