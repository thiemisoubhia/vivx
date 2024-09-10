# Etapa de construção
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:11-jre-slim
COPY --from=build /app/target/ecommerce-1.0.war /app/ecommerce.war
ENTRYPOINT ["java", "-jar", "/app/ecommerce.war"]
