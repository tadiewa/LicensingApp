# Stage 1: Build stage
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Package the application as a JAR
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM openjdk:17-slim
WORKDIR /app

# Copy the Spring Boot repackaged JAR from the build stage
COPY --from=build /app/target/organizationservice-0.0.1-SNAPSHOT.jar /app/app.jar

# Add volume pointing to /tmp (used by Spring Boot for temp files)
VOLUME /tmp

# Run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]
