# Usa una imagen base con Java 21 (asegúrate de que esté disponible)
FROM openjdk:21-jdk-slim

# Establece un directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado al contenedor (reemplaza "tu-proyecto.jar" con el nombre real de tu archivo JAR)
COPY target/AppClinica-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto donde la aplicación Spring Boot va a estar escuchando (ajusta si tu puerto es diferente)
EXPOSE 8085

# Comando para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]