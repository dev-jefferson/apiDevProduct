# Use a imagem do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR gerado para o container
COPY target/apiDevProduct-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de inicialização do container
ENTRYPOINT ["java", "-jar", "app.jar"]
