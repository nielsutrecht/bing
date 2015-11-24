package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class RoutePoint {
    @JsonProperty
    String type;

    @JsonProperty
    double[] coordinates;

    @JsonProperty
    String calculationMethod;

    @JsonProperty
    List<String> usageTypes;

    @JsonProperty
    String description;

    @JsonProperty
    boolean isVia;

    @JsonProperty
    String locationIdentifier;

    @JsonProperty
    int routePathIndex;
}
