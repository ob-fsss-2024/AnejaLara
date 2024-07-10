package com.example.demo.location;

import com.example.demo.location.client.dto.LocationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("get-location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/get-location")
    public LocationResponse getCoordinates(@RequestParam String name) {
        return locationService.getLocation(name);
    }
}
