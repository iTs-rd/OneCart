#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./cloud
#
#RUN mvn -f ./cloud clean install
#
#FROM openjdk:17
#
#COPY --from=MAVEN_BUILD ./cloud/target/*.jar gateway.jar
#
#ENTRYPOINT ["java", "-jar", "/gateway.jar"]
#
#EXPOSE 9090


FROM openjdk:17

COPY /target/*.jar gateway.jar

ENTRYPOINT ["java", "-jar", "/gateway.jar"]

EXPOSE 9090
