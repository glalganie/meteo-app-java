# Meteo Web App


Applicazione web sviluppata in Java e Spring Boot per visualizzare i dati meteorologici degli ultimi 14 giorni per diverse località italiane. I dati vengono recuperati tramite le API di [Open-Meteo](https://open-meteo.com/) e visualizzati in grafici interattivi.

### 🌐 Demo Live

➡️  L'applicazione è attiva e funzionante su Railway. Provala subito!


[![Deploy on Railway](https://railway.app/button.svg)](http://metro.proxy.rlwy.net:28101/)
---

### ✨ Screenshot


 <img width="1171" height="977" alt="image" src="https://github.com/user-attachments/assets/339e6fa7-1851-4274-ba70-46bc84cc26c2" />

---

### 🚀 Funzionalità

-   Selezione di una località da una lista predefinita (Roma, Milano, Napoli, etc.).
-   Visualizzazione dei dati storici degli ultimi 14 giorni.
-   Grafici a barre interattivi per:
    -   🌡️ Temperatura Massima (°C)
    -   💨 Vento Massimo (km/h)
    -   💧 Precipitazioni (mm)
    -   ☁️ Nuvolosità (%)
    -    pressurapressione (hPa)
-   🔔 Notifica di allerte meteo in tempo reale per la località selezionata.
-   Progetto containerizzato con Docker per un facile deploy.

---

### 🛠️ Stack Tecnologico

-   **Backend**: Java 17, Spring Boot 3
-   **Frontend**: HTML5, CSS3, JavaScript
-   **Template Engine**: Thymeleaf
-   **Libreria Grafici**: Chart.js
-   **Build Tool**: Maven
-   **Containerizzazione**: Docker
-   **Piattaforma di Deploy**: Railway

---

### ⚙️ Come Eseguire in Locale

#### Prerequisiti

-   JDK 17 o superiore
-   Maven 3.8+
-   Docker (per l'esecuzione tramite container)

#### Esecuzione con Maven

1.  Clona il repository:
    ```bash
    git clone https://github.com/glalganie/meteo-app-java.git
    cd meteo-app-java
    ```

2.  Esegui l'applicazione:
    ```bash
    ./mvnw spring-boot:run
    ```

3.  Apri il browser e vai a `http://localhost:8080`.

#### Esecuzione con Docker

1.  Costruisci l'immagine Docker:
    ```bash
    docker build -t meteo-app .
    ```

2.  Esegui il container:
    ```bash
    docker run -p 8080:8080 meteo-app
    ```

3.  Apri il browser e vai a `http://localhost:8080`.

## 📖 Interpretazione dei Dati

I dati sono forniti da Open-Meteo e sono interpretati come segue:

-   **Temperatura Massima**: Misurata a 2 metri dal suolo.
-   **Vento Massimo**: Velocità massima del vento a 10 metri dal suolo.
-   **Precipitazioni**: Somma delle precipitazioni giornaliere.
-   **Nuvolosità**: Percentuale media di cielo coperto da nuvole.
-   **Pressione**: Pressione media a livello della superficie.
-   **Allerte Meteo**: Generate interpretando i [codici meteo WMO](https://www.nodc.noaa.gov/archive/arc0021/0002199/1.1/data/0-data/HTML/WMO-CODE/WMO4677.HTM) forniti dall'API. L'implementazione attuale segnala solo condizioni di pioggia intensa o temporali.
