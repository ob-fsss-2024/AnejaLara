package com.example.demo.location;

import com.example.demo.location.client.OpenCageClient;
import com.example.demo.location.client.dto.LocationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
   private final OpenCageClient openCageClient;


    public LocationService(OpenCageClient openCageClient) {
        this.openCageClient = openCageClient;
    }

    public LocationResponse getLocation(String name) {
        return openCageClient.getCoordinates(name);
    }
}
