package com.nibado.bing.enums;

public enum TimeType {
    ARRIVAL("Arrival"),
    DEPARTURE("Departure"),
    LAST_AVAILABLE("LastAvailable");

    private String value;

    TimeType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
