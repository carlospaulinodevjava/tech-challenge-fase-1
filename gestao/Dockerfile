# Usa imagem leve e compatível com JDK 21
FROM eclipse-temurin:21-jdk-alpine

# Define diretório de trabalho
WORKDIR /app

# Copia o JAR gerado pelo Maven
COPY target/gestao-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
