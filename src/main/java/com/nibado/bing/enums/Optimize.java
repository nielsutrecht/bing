package com.nibado.bing.enums;

public enum Optimize {
    DISTANCE("distance"),
    TIME("time"),
    TIME_WITH_TRAFFIC("timeWithTraffic"),
    TIME_AVOID_CLOSURE("timeAvoidClosure");

    private String value;

    Optimize(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}