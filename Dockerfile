# Etapa de construção
FROM maven:3.8.4-openjdk-8-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:8-jre-slim
COPY --from=build /app/target/*.war /app/app.war

# Expor a porta 80 no contêiner
ENV PORT 80
EXPOSE 80

# Executar o app e passar a porta como argumento
ENTRYPOINT ["java", "-jar", "/app/app.war", "--server.port=80"]
