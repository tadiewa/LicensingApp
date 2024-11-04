FROM openjdk:17-jdk

WORKDIR /app

COPY /target/configServer-1.0.jar  /app/configServer.jar

EXPOSE 8079

CMD ["java","-jar","configServer.jar"]