package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nibado.bing.Leg;

import java.util.List;

class RouteLeg {
    @JsonProperty
    RoutePoint actualStart;

    @JsonProperty
    RoutePoint actualEnd;

    @JsonProperty
    List<Via> alternateVias;

    @JsonProperty
    int cost;

    @JsonProperty
    String description;

    @JsonProperty
    RouteLocation startLocation;

    @JsonProperty
    RouteLocation endLocation;

    @JsonProperty
    List<RouteItenaryItem> itineraryItems;

    @JsonProperty
    String routeRegion;

    @JsonProperty
    List<SubLeg> routeSubLegs;

    @JsonProperty
    double travelDistance;

    @JsonProperty
    int travelDuration;

    public Leg toLeg() {
        Leg leg = new Leg();

        leg.setDescription(description);
        leg.setRegion(routeRegion);
        leg.setTravelDistance(travelDistance);
        leg.setTravelDuration(travelDuration);
        leg.setStartLocation(startLocation.toLocation());
        leg.setEndLocation(endLocation.toLocation());

        return leg;
    }

    static class SubLeg {
        @JsonProperty
        RoutePoint startWaypoint;

        @JsonProperty
        RoutePoint endWaypoint;

        @JsonProperty
        double travelDistance;

        @JsonProperty
        int travelDuration;
    }

}
