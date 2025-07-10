# Meteo Web App

Applicazione web sviluppata in Java e Spring Boot per visualizzare i dati meteorologici degli ultimi 14 giorni per diverse località italiane. I dati vengono recuperati tramite le API di [Open-Meteo](https://open-meteo.com/) e visualizzati in grafici interattivi.

## ✨ Funzionalità

-   Selezione di una località da una lista predefinita.
-   Visualizzazione dei dati storici degli ultimi 14 giorni.
-   Grafici a barre interattivi per i seguenti parametri:
    -   Temperatura Massima (`°C`)
    -   Vento Massimo (`km/h`)
    -   Precipitazioni totali (`mm`)
    -   Nuvolosità media (`%`)
    -   Pressione atmosferica media (`hPa`)
-   Notifica di eventuali allerte meteo per la giornata corrente.
-   Progetto interamente containerizzato con Docker.

## 🛠️ Stack Tecnologico

-   **Backend**: Java 17, Spring Boot 3
-   **Frontend**: HTML5, CSS3, JavaScript (ES6)
-   **Template Engine**: Thymeleaf
-   **Libreria Grafici**: Chart.js
-   **Build Tool**: Maven
-   **Containerizzazione**: Docker

## 🚀 Come Eseguire

### Prerequisiti

-   JDK 17 o superiore
-   Maven 3.6+
-   Docker (per l'esecuzione tramite container)

### Esecuzione Locale (tramite Maven)

1.  Clona il repository:
    ```bash
    git clone https://github.com/glalganie/meteo-app-java.git
    cd meteoapp
    ```

2.  Esegui l'applicazione con il wrapper di Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

3.  Apri il browser e vai a `http://localhost:8080`.

### Esecuzione tramite Docker

1.  Clona il repository (se non l'hai già fatto).

2.  Costruisci l'immagine Docker:
    ```bash
    docker build -t meteo-app .
    ```

3.  Esegui il container Docker:
    ```bash
    docker run -p 8080:8080 meteo-app
    ```

4.  Apri il browser e vai a `http://localhost:8080`.

## 📖 Interpretazione dei Dati

I dati sono forniti da Open-Meteo e sono interpretati come segue:

-   **Temperatura Massima**: Misurata a 2 metri dal suolo.
-   **Vento Massimo**: Velocità massima del vento a 10 metri dal suolo.
-   **Precipitazioni**: Somma delle precipitazioni giornaliere.
-   **Nuvolosità**: Percentuale media di cielo coperto da nuvole.
-   **Pressione**: Pressione media a livello della superficie.
-   **Allerte Meteo**: Generate interpretando i [codici meteo WMO](https://www.nodc.noaa.gov/archive/arc0021/0002199/1.1/data/0-data/HTML/WMO-CODE/WMO4677.HTM) forniti dall'API. L'implementazione attuale segnala solo condizioni di pioggia intensa o temporali.
