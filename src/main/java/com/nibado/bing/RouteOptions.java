package com.nibado.bing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RouteOptions {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    boolean avoidHighways;
    boolean avoidTolls;
    boolean minimizeHighways;
    boolean minimizeTolls;
    boolean excludeItinerary;
    boolean includeRoutePath;
    boolean includeTransitStops;
    boolean routeSummariesOnly;
    int distanceBeforeFirstTurn = -1;
    int heading = -1;
    Optimize optimize = null;
    TimeType timeType = null;
    TravelMode travelMode = null;
    DistanceUnit distanceUnit = DistanceUnit.Kilometer;
    double[] tolerances;
    String dateTime;
    int maxSolutions = -1;


    public RouteOptions avoidHighways() {
        avoidHighways = true;

        return this;
    }

    public RouteOptions avoidTolls() {
        avoidTolls = true;

        return this;
    }

    public RouteOptions minimizeHighways() {
        minimizeHighways = true;

        return this;
    }

    public RouteOptions minimizeTolls() {
        minimizeTolls = true;

        return this;
    }

    public RouteOptions excludeItinerary() {
        excludeItinerary = true;

        return this;
    }

    public RouteOptions includeRoutePath() {
        includeRoutePath = true;

        return this;
    }

    public RouteOptions includeTransitStops() {
        includeTransitStops = true;

        return this;
    }

    public RouteOptions routeSummariesOnly() {
        routeSummariesOnly   = true;

        return this;
    }

    public RouteOptions distanceBeforeFirstTurn(int distanceBeforeFirstTurn) {
        this.distanceBeforeFirstTurn = distanceBeforeFirstTurn;

        return this;
    }

    public RouteOptions heading(int heading) {
        this.heading = heading;

        return this;
    }

    public RouteOptions optimize(Optimize optimize) {
        this.optimize = optimize;

        return this;
    }

    public RouteOptions timeType(TimeType timeType) {
        this.timeType = timeType;

        return this;
    }

    public RouteOptions travelMode(TravelMode travelMode) {
        this.travelMode = travelMode;

        return this;
    }

    public RouteOptions distanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;

        return this;
    }

    public RouteOptions dateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime.format(FORMATTER);
        return this;
    }

    public RouteOptions dateTime(LocalDate date) {
        return dateTime(LocalDateTime.of(date, LocalTime.of(0,0)));
    }

    public RouteOptions dateTime(LocalTime time) {
        return dateTime(LocalDateTime.of(LocalDate.now(), time));
    }

    public RouteOptions tolerances(double... tolerances) {
        if(tolerances.length > 7) {
            throw new IllegalArgumentException("tolerances can't be longer than 7 elements");
        }
        this.tolerances = tolerances;

        return this;
    }

    public RouteOptions maxSolutions(int maxSolutions) {
        if(maxSolutions < 1 || maxSolutions > 3) {
            throw new IllegalArgumentException("Only maxSolutions between 1 and 3 inclusive are valid: " + maxSolutions);
        }
        this.maxSolutions = maxSolutions;

        return this;
    }

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

    public enum TravelMode {
        DRIVING("Driving"),
        WALKING("Walking"),
        TRANSIT("Transit");

        private String value;

        TravelMode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum DistanceUnit {
        Kilometer,
        Mile
    }
}
