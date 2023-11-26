#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./
#
#RUN mvn clean install
#
#FROM openjdk:17
#
#COPY --from=MAVEN_BUILD /target/*.jar order.jar
#
#ENTRYPOINT ["java", "-jar", "/order.jar"]
#
#EXPOSE 8082


FROM openjdk:17

COPY /target/*.jar order.jar

ENTRYPOINT ["java", "-jar", "/order.jar"]

EXPOSE 8082
