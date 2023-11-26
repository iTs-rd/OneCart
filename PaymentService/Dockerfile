#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./
#
#RUN mvn clean install
#
#FROM openjdk:17
#
#COPY --from=MAVEN_BUILD /target/*.jar payment.jar
#
#ENTRYPOINT ["java", "-jar", "/payment.jar"]
#
#EXPOSE 8083


FROM openjdk:17

COPY /target/*.jar payment.jar

ENTRYPOINT ["java", "-jar", "/payment.jar"]

EXPOSE 8083
