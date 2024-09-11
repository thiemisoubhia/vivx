# Etapa de construção
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de execução com Tomcat
FROM tomcat:10.1-jdk11-slim

# Instalar OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-17-openjdk-amd64/bin/java 1 && \
    update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/java-17-openjdk-amd64/bin/javac 1 && \
    apt-get clean

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080
