package com.nibado.bing;

import com.nibado.bing.enums.DistanceUnit;
import com.nibado.bing.enums.DurationUnit;
import com.nibado.bing.enums.TrafficCongestion;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

import static com.nibado.bing.Util.formatDuration;

public class Route {
    private BoundingBox boundingBox;
    private DistanceUnit distanceUnit;
    private DurationUnit durationUnit;
    private TrafficCongestion trafficCongestion;
    private double travelDistance;
    private int travelDuration;
    private int travelDurationTraffic;
    private List<Leg> legs;

    public Route() {
    }

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

    public int getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(int travelDuration) {
        this.travelDuration = travelDuration;
    }

    public int getTravelDurationTraffic() {
        return travelDurationTraffic;
    }

    public void setTravelDurationTraffic(int travelDurationTraffic) {
        this.travelDurationTraffic = travelDurationTraffic;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        Duration d1 = Duration.ofSeconds(travelDuration);
        Duration d2 = Duration.ofSeconds(travelDurationTraffic);

        return String.format(Locale.ROOT, "Distance: %s km, duration: %s, duration with traffic: %s", (int)travelDistance, formatDuration(d1), formatDuration(d2));
    }
}
