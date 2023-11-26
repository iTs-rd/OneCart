#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./
#
#RUN mvn clean install
#
#FROM openjdk:17
#
#COPY --from=MAVEN_BUILD /target/*.jar account.jar
#
#ENTRYPOINT ["java", "-jar", "/account.jar"]
#
#EXPOSE 8081


FROM openjdk:17

COPY /target/*.jar account.jar

ENTRYPOINT ["java", "-jar", "/account.jar"]

EXPOSE 8081
