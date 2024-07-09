package com.example.demo.location.client;

import com.example.demo.location.client.dto.LocationResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface OpenCageClient {
    @GetExchange("/json?key=6c6909dadaf4499e9412286a4200c434&q={cityName}&pretty=1")
    LocationResponse getCoordinates(@PathVariable String cityName);
}
