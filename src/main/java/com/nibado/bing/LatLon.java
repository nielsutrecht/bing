package com.nibado.bing;

public class LatLon {
    private double lattitude;
    private double longitude;

    public LatLon(double lattitude, double longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public static LatLon from(String value) {
        if(value == null || value.isEmpty()) {
            return null;
        }
        String[] parts = value.split(",");
        return new LatLon(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
    }
}
