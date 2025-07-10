package it.webapp.meteoapp.controller;

import it.webapp.meteoapp.model.Location;
import it.webapp.meteoapp.model.MeteoResponse;
import it.webapp.meteoapp.service.MeteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MeteoController {

    @Autowired
    private MeteoService meteoService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String location) {
        model.addAttribute("locations", Location.values());

        if (location != null && !location.isEmpty()) {
            try {
                Location selectedLocation = Location.valueOf(location.toUpperCase());
                model.addAttribute("selectedLocation", selectedLocation);
                
                MeteoResponse meteoData = meteoService.getHistoricalData(selectedLocation.getLatitude(), selectedLocation.getLongitude());
                
                // Formatta le date per una migliore leggibilità
                List<String> formattedDates = meteoData.getDaily().getTime().stream()
                        .map(dateStr -> LocalDate.parse(dateStr).format(DateTimeFormatter.ofPattern("dd/MM")))
                        .collect(Collectors.toList());

                model.addAttribute("meteoData", meteoData);
                model.addAttribute("labels", formattedDates); // Date per l'asse X del grafico

                // Aggiungi l'allerta meteo
                meteoService.getWeatherAlert(selectedLocation.getLatitude(), selectedLocation.getLongitude())
                        .ifPresent(alert -> model.addAttribute("alert", alert));
                
            } catch (IllegalArgumentException e) {
                model.addAttribute("error", "Località non valida.");
            }
        }

        return "index"; // Nome del file HTML in templates/
    }
}