#FROM maven:3.8.3-openjdk-17 AS MAVEN_BUILD
#
#COPY ./ ./
#
#RUN mvn clean install
#
#FROM openjdk:17
#
#COPY --from=MAVEN_BUILD /target/*.jar product.jar
#
#ENTRYPOINT ["java", "-jar", "/product.jar"]
#
#EXPOSE 8084


FROM openjdk:17

COPY /target/*.jar product.jar

ENTRYPOINT ["java", "-jar", "/product.jar"]

EXPOSE 8084
