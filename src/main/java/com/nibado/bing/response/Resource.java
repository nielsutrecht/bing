package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class Resource {
    @JsonProperty
    String id;

    @JsonProperty(required = true, value = "__type")
    String type;

    @JsonProperty(required = true, value = "bbox")
    double[] boundingBox;

    @JsonProperty
    String distanceUnit;

    @JsonProperty
    String durationUnit;

    @JsonProperty
    String trafficCongestion;

    @JsonProperty
    String trafficDataUsed;

    @JsonProperty
    double travelDistance;

    @JsonProperty
    double travelDuration;

    @JsonProperty
    double travelDurationTraffic;
}
