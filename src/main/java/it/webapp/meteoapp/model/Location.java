package it.webapp.meteoapp.model;

import lombok.Getter;

@Getter
public enum Location {
    ROMA("Roma", 41.9028, 12.4964),
    MILANO("Milano", 45.4642, 9.1900),
    NAPOLI("Napoli", 40.8518, 14.2681),
    TORINO("Torino", 45.0703, 7.6869),
    PALERMO("Palermo", 38.1157, 13.3615);

    private final String displayName;
    private final double latitude;
    private final double longitude;

    Location(String displayName, double latitude, double longitude) {
        this.displayName = displayName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}