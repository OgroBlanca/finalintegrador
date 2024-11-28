# Etapa 1: Construcción con Maven
FROM maven:3.8-openjdk-21-slim AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el código fuente del repositorio al contenedor
COPY . /app

# Ejecuta Maven para construir el archivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Creación de la imagen final que ejecutará el JAR
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado en la etapa de construcción
COPY --from=build /app/target/AppClinica-0.0.1-SNAPSHOT.jar /app/app.jar

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]