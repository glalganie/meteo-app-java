package it.webapp.meteoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoResponse {
    private Daily daily;
    private DailyUnits daily_units;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Daily {
        private List<String> time;
        private List<Double> temperature_2m_max;
        private List<Double> wind_speed_10m_max;
        private List<Double> precipitation_sum;
        private List<Double> cloud_cover_mean;
        private List<Double> surface_pressure_mean;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DailyUnits {
        private String temperature_2m_max;
        private String wind_speed_10m_max;
        // ... altri campi unità se necessari
    }
}