# 🌦️ Meteo Web App



Applicazione web sviluppata in Java e Spring Boot per visualizzare i dati meteorologici degli ultimi 14 giorni per diverse località italiane. I dati vengono recuperati tramite le API di [Open-Meteo](https://open-meteo.com/) e visualizzati in grafici interattivi.

### 🌐 Demo Live

 L'applicazione è attiva e funzionante su Railway. Provala subito!


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
-   **Build Tool**: Maven (usato internamente da Docker durante il build)
-   **Containerizzazione**: Docker & Docker Compose
-   **Piattaforma di Deploy**: Railway
---

### 🚀 Avvio Rapido con Docker Compose

Questo progetto è pensato per essere eseguito con Docker, eliminando la necessità di installare Java o Maven localmente.

#### Prerequisiti

L'unico prerequisito è avere **Docker e Docker Compose** installati sul tuo sistema.
*   [Installa Docker Desktop](https://www.docker.com/products/docker-desktop/) (include già Docker Compose).

#### Istruzioni per l'Avvio

1.  **Clona il repository:**
    ```bash
    git clone https://github.com/glalganie/meteo-app-java.git
    ```

2.  **Entra nella cartella del progetto:**
    ```bash
    cd meteo-app-java
    ```

3.  **Avvia l'applicazione con un solo comando:**
    ```bash
    docker compose up
    ```
    *(Nota: sulle versioni più vecchie di Docker potresti dover usare `docker-compose up` con il trattino)*

Docker costruirà l'immagine e avvierà l'applicazione. La prima volta potrebbe richiedere alcuni minuti.

4.  **Apri il browser e vai a:**
    `http://localhost:8081`

#### Suggerimenti Utili

*   **Per forzare la ricostruzione dell'immagine** dopo aver modificato il codice Java, usa il flag `--build`:
    ```bash
    docker compose up --build
    ```
*   **Per fermare l'applicazione** e rimuovere il container, premi `Ctrl+C` nel terminale e poi digita:
    ```bash
    docker compose down
    ```

---



## 📖 Interpretazione dei Dati

I dati sono forniti da Open-Meteo e sono interpretati come segue:

-   **Temperatura Massima**: Misurata a 2 metri dal suolo.
-   **Vento Massimo**: Velocità massima del vento a 10 metri dal suolo.
-   **Precipitazioni**: Somma delle precipitazioni giornaliere.
-   **Nuvolosità**: Percentuale media di cielo coperto da nuvole.
-   **Pressione**: Pressione media a livello della superficie.
-   **Allerte Meteo**: Generate interpretando i [codici meteo WMO](https://www.datameteo.com/meteo/dati_meteo_attuali.html) forniti dall'API. L'implementazione attuale segnala solo condizioni di pioggia intensa o temporali.
