package it.webapp.meteoapp.service;

import it.webapp.meteoapp.model.AlertResponse;
import it.webapp.meteoapp.model.MeteoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Service
public class MeteoService {

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String HISTORY_API_URL = "https://archive-api.open-meteo.com/v1/archive";
    private static final String FORECAST_API_URL = "https://api.open-meteo.com/v1/forecast";

    // Mappa dei codici WMO per le allerte (semplificata)
    private static final Map<Integer, String> WMO_CODES = Map.ofEntries(
            Map.entry(61, "Allerta Pioggia Leggera"),
            Map.entry(63, "Allerta Pioggia Moderata"),
            Map.entry(65, "Allerta Pioggia Intensa"),
            Map.entry(81, "Allerta Rovesci Violenti"),
            Map.entry(95, "Allerta Temporale"),
            Map.entry(96, "Allerta Temporale con Grandine Leggera"),
            Map.entry(99, "Allerta Temporale con Grandine Intensa")
    );


    public MeteoResponse getHistoricalData(double latitude, double longitude) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(14);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String url = UriComponentsBuilder.fromUriString(HISTORY_API_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("start_date", startDate.format(formatter))
                .queryParam("end_date", endDate.format(formatter))
                .queryParam("daily", "temperature_2m_max,precipitation_sum,wind_speed_10m_max,cloud_cover_mean,surface_pressure_mean")
                .queryParam("timezone", "Europe/Rome")
                .toUriString();

        return restTemplate.getForObject(url, MeteoResponse.class);
    }
    
    public Optional<String> getWeatherAlert(double latitude, double longitude) {
        String url = UriComponentsBuilder.fromUriString(FORECAST_API_URL)
                .queryParam("latitude", latitude)
                .queryParam("longitude", longitude)
                .queryParam("current", "weather_code")
                .toUriString();

        AlertResponse response = restTemplate.getForObject(url, AlertResponse.class);
        
        if (response != null && response.getCurrent() != null) {
            int code = response.getCurrent().getWeatherCode();
            return Optional.ofNullable(WMO_CODES.get(code));
        }
        return Optional.empty();
    }
}