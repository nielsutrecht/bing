package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class RouteItenaryItem {
    @JsonProperty
    String compassDirection;

    @JsonProperty
    List<Detail> details;

    @JsonProperty
    String exit;

    @JsonProperty
    String iconType;

    @JsonProperty
    Instruction instruction;

    @JsonProperty
    RoutePoint maneuverPoint;

    @JsonProperty
    String sideOfStreet;

    @JsonProperty
    List<String> signs;

    @JsonProperty
    String tollZone;

    @JsonProperty
    String towardsRoadName;

    @JsonProperty
    String transitTerminus;

    @JsonProperty
    double travelDistance;

    @JsonProperty
    int travelDuration;

    @JsonProperty
    String travelMode;

    @JsonProperty
    List<Warning> warnings;

    @JsonProperty
    List<Hint> hints;

    static class Detail {
        @JsonProperty
        String compassDegrees;

        @JsonProperty
        int[] endPathIndices;

        @JsonProperty
        String maneuverType;

        @JsonProperty
        String mode;

        @JsonProperty
        List<String> names;

        @JsonProperty
        List<String> locationCodes;

        @JsonProperty
        String roadType;

        @JsonProperty
        int[] startPathIndices;

        @JsonProperty
        RoadShieldRequestParameters roadShieldRequestParameters;
    }

    static class Instruction {
        @JsonProperty
        String formattedText;

        @JsonProperty
        String maneuverType;

        @JsonProperty
        String text;
    }

    static class RoadShieldRequestParameters {
        @JsonProperty
        int bucket;

        @JsonProperty
        List<Shield> shields;
    }

    static class Shield {
        @JsonProperty
        List<String> labels;

        @JsonProperty(value = "roadShieldType")
        int type;
    }

    static class Warning {
        @JsonProperty
        String severity;

        @JsonProperty
        String text;

        @JsonProperty
        String warningType;

        @JsonProperty
        String origin;

        @JsonProperty
        String to;
    }

    static class Hint {
        @JsonProperty
        String hintType;

        @JsonProperty
        String text;
    }
}
