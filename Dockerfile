FROM openjdk:17
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean package -DskipTests
COPY target/smartparking-0.0.1-SNAPSHOT.jar /app/smartparking-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/smartparking-0.0.1-SNAPSHOT.jar"]
