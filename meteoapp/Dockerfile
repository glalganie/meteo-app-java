# --- Stadio 1: Build ---
# Usiamo un'immagine Maven con OpenJDK 17 per compilare il progetto
FROM maven:3.9-eclipse-temurin-17 AS build

# Impostiamo la directory di lavoro all'interno del container
WORKDIR /app

# Copiamo il pom.xml per scaricare le dipendenze
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamo il resto del codice sorgente
COPY src ./src

# Compiliamo l'applicazione, creando il file .jar. Saltiamo i test per velocizzare il build.
RUN mvn clean package -DskipTests

# --- Stadio 2: Run ---
# Usiamo un'immagine JRE (Java Runtime Environment) molto più leggera per eseguire l'app
FROM eclipse-temurin:17-jre-focal

# Impostiamo la directory di lavoro
WORKDIR /app

# Copiamo solo il file .jar compilato dallo stadio di build
COPY --from=build /app/target/*.jar app.jar

# Esponiamo la porta 8080 su cui gira l'applicazione Spring Boot
EXPOSE 8080

# Comando per avviare l'applicazione quando il container parte
ENTRYPOINT ["java", "-jar", "app.jar"]