# O código-fonte da aplicação é copiado para o diretório /app e o Maven é executado
# para gerar o pacote (excluindo os testes para agilizar o processo de build).
# Fase de Build
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean package -DskipTests

# O arquivo JAR gerado na fase de build é copiado para o diretório /app e o container
# é configurado para expor a porta 8080.
FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]