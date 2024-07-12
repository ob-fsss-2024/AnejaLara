package com.example.demo.location;

import com.example.demo.location.client.OpenCageClient;
import com.example.demo.location.client.dto.LocationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private final Logger logger = LoggerFactory.getLogger(LocationService.class.getName());
   private final OpenCageClient openCageClient;

    public LocationService(OpenCageClient openCageClient) {
        this.openCageClient = openCageClient;
    }

    public LocationResponse getLocation(String name) {
        logger.info("Getting coordinates for location: " + name);
        return openCageClient.getCoordinates(name);
    }
}
