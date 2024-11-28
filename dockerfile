# Usa una imagen base ligera de Debian
FROM debian:bullseye-slim

# Actualiza el repositorio e instala las dependencias necesarias
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    gnupg \
    lsb-release \
    ca-certificates \
    openjdk-17-jdk

# Verifica la versión de Java 17
RUN java -version

# Etapa 1: Construcción con Maven y OpenJDK 18
FROM maven:3.8-openjdk-17-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el código fuente al contenedor
COPY src /app/src

# Ejecuta el proceso de construcción
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]