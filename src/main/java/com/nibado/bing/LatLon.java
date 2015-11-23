package com.nibado.bing;

public class LatLon {
    private double lat;
    private double lon;

    public LatLon(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLattitude() {
        return lat;
    }

    public double getLongitude() {
        return lon;
    }
}
