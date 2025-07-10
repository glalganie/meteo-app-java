package it.webapp.meteoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertResponse {
    @JsonProperty("current")
    private CurrentWeather current;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentWeather {
        @JsonProperty("weather_code")
        private int weatherCode;
    }
}