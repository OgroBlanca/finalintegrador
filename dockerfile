# Etapa 1: Construcción con Maven y OpenJDK 17
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

# Etapa 2: Imagen final con OpenJDK 17
FROM openjdk:17-jdk-slim

# Copia el JAR generado en la etapa de construcción
COPY --from=build /app/target/*.jar /app/app.jar

# Expone el puerto 8080 para la aplicación
EXPOSE 8085

# Define el comando de inicio para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]