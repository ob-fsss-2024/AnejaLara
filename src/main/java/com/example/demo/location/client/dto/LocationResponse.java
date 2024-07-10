package com.example.demo.location.client.dto;

import java.util.List;

public record LocationResponse(List<LocationResponseItem> results) {

}

record LocationResponseItem(Geometry geometry){}

record Geometry(double lat, double lng) {}