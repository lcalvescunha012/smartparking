# Use a base image with JDK 17 (adjust if using a different version)
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/smartparking-0.0.1-SNAPSHOT.jar /app/smartparking-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/smartparking-0.0.1-SNAPSHOT.jar"]
