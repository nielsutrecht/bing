package com.nibado.bing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Leg {
    private Location startLocation;
    private Location endLocation;
    private String region;
    private String description;

    private double travelDistance;
    private int travelDuration;

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public int getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(int travelDuration) {
        this.travelDuration = travelDuration;
    }

    public static class Location {
        private BoundingBox boundingBox;
        private String name;

        public BoundingBox getBoundingBox() {
            return boundingBox;
        }

        public String getName() {
            return name;
        }

        public void setBoundingBox(BoundingBox boundingBox) {
            this.boundingBox = boundingBox;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
