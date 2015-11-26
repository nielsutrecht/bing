package com.nibado.bing.enums;

public enum TravelMode {
    DRIVING,
    WALKING,
    TRANSIT;

    public static TravelMode from(String travelMode) {
        return TravelMode.valueOf(travelMode.toUpperCase());
    }
}
