package com.example.demo.weather;

import com.example.demo.location.LocationService;
import com.example.demo.weather.client.WeatherClient;
import com.example.demo.weather.client.dto.DailyWeather;
import com.example.demo.weather.client.dto.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("weather")
public class WeatherController {
    private final Logger logger = LoggerFactory.getLogger(LocationService.class.getName());
    private final WeatherClient weatherClient;

    public WeatherController(final WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/forecast")
    public WeatherResponse getWeather(@RequestParam final Double latitude, @RequestParam final Double longitude) {
        logger.info("Getting weather information for coordinates: " + latitude + ", " + longitude);
        WeatherResponse response = weatherClient.getWeather(latitude, longitude);
        DailyWeather daily = response.daily();

        List<String> weatherDescriptions = daily.weathercode().stream()
                .map(code -> convertWeatherCodeToDesc(Integer.parseInt(code)))
                .collect(Collectors.toList());

        DailyWeather updatedDaily = new DailyWeather(daily.sunrise(), daily.sunset(), weatherDescriptions);

        return new WeatherResponse(response.latitude(), response.longitude(), response.timezone(), response.elevation(), updatedDaily);
    }

    private String convertWeatherCodeToDesc(int weatherCode) {
        return switch (weatherCode) {
            case 0 -> "Clear sky";
            case 1 -> "Mainly clear";
            case 2 -> "Partly cloudy";
            case 3 -> "Overcast";
            case 45 -> "Fog";
            case 48 -> "Depositing rime fog";
            case 51 -> "Drizzle: Light intensity";
            case 53 -> "Drizzle: Moderate intensity";
            case 55 -> "Drizzle: Dense intensity";
            case 56 -> "Freezing Drizzle: Light intensity";
            case 57 -> "Freezing Drizzle: Dense intensity";
            case 61 -> "Rain: Slight intensity";
            case 63 -> "Rain: Moderate intensity";
            case 65 -> "Rain: Heavy intensity";
            case 66 -> "Freezing Rain: Light intensity";
            case 67 -> "Freezing Rain: Heavy intensity";
            case 71 -> "Snow fall: Slight intensity";
            case 73 -> "Snow fall: Moderate intensity";
            case 75 -> "Snow fall: Heavy intensity";
            case 77 -> "Snow grains";
            case 80 -> "Rain showers: Slight intensity";
            case 81 -> "Rain showers: Moderate intensity";
            case 82 -> "Rain showers: Violent intensity";
            case 85 -> "Snow showers slight";
            case 86 -> "Snow showers heavy";
            case 95 -> "Thunderstorm: Slight or moderate";
            case 96 -> "Thunderstorm with slight hail";
            case 99 -> "Thunderstorm with heavy hail";
            default -> "Unknown weather condition";
        };
    }
}