#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#RUN mkdir service
#
#COPY ./ ./service
#
#RUN mvn -f ./service clean install

FROM openjdk:17

COPY /target/*.jar service.jar

ENTRYPOINT ["java", "-jar", "/service.jar"]

EXPOSE 8761
