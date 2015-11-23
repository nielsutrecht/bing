package com.nibado.bing;

import java.time.Duration;
import java.util.Locale;

public class Route {
    private BoundingBox boundingBox;
    private DistanceUnit distanceUnit;
    private DurationUnit durationUnit;
    private TrafficCongestion trafficCongestion;
    private double travelDistance;
    private double travelDuration;
    private double travelDurationTraffic;

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public DurationUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(DurationUnit durationUnit) {
        this.durationUnit = durationUnit;
    }

    public TrafficCongestion getTrafficCongestion() {
        return trafficCongestion;
    }

    public void setTrafficCongestion(TrafficCongestion trafficCongestion) {
        this.trafficCongestion = trafficCongestion;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(double travelDistance) {
        this.travelDistance = travelDistance;
    }

    public double getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(double travelDuration) {
        this.travelDuration = travelDuration;
    }

    public double getTravelDurationTraffic() {
        return travelDurationTraffic;
    }

    public void setTravelDurationTraffic(double travelDurationTraffic) {
        this.travelDurationTraffic = travelDurationTraffic;
    }

    public enum DistanceUnit {
        MILE,
        KILOMETER
    }

    public enum DurationUnit {
        SECOND
    }

    public enum TrafficCongestion {
        MEDIUM,
        MILD
    }

    @Override
    public String toString() {
        Duration d1 = Duration.ofSeconds((long)travelDuration);
        Duration d2 = Duration.ofSeconds((long)travelDurationTraffic);

        return String.format(Locale.ROOT, "Distance: %s km, duration: %s, duration with traffic: %s", (int)travelDistance, format(d1), format(d2));
    }

    private String format(Duration dur) {
        return String.format(Locale.ROOT, "%s hours, %s minutes", dur.toHours(), dur.toMinutes() % (dur.toHours() * 60));
    }
}
