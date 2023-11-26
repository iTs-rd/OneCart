#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./config
#
#RUN mvn -f ./config clean install
#
#FROM openjdk:17
#
#COPY --from=MAVEN_BUILD ./config/target/*.jar config.jar
#
#ENTRYPOINT ["java", "-jar", "/config.jar"]
#
#EXPOSE 9296


FROM openjdk:17

COPY /target/*.jar config.jar

ENTRYPOINT ["java", "-jar", "/config.jar"]

EXPOSE 9296
