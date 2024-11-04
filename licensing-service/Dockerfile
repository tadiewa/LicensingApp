FROM openjdk:17-jdk

WORKDIR /app

COPY target/licensing-service-1.0.jar /app/licensing-service.jar

EXPOSE 8997

CMD ["java", "-jar", "licensing-service.jar"]