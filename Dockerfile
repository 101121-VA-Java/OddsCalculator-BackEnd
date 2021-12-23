<<<<<<< HEAD
FROM openjdk:8-jdk-alpine
COPY target/oddsCalculator.jar  oddsCalculator.jar
ENTRYPOINT ["java", "-jar", "/oddsCalculator.jar"]
=======
FROM openjdk:8-jdk-alpine as build
COPY target/oddsCalculator.jar  oddsCalculator.jar
ENTRYPOINT ["java", "-jar", "/oddsCalculator.jar"]
EXPOSE 8080
>>>>>>> 1c52ac5b8c4e2e79a2133d7807e9562e19a49389
