package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nibado.bing.BoundingBox;
import com.nibado.bing.Leg;

import java.util.List;

class RouteLocation {
    @JsonProperty
    double[] bbox;

    @JsonProperty
    String name;

    @JsonProperty
    RoutePoint point;

    @JsonProperty
    RouteAddress address;

    @JsonProperty
    String confidence;

    @JsonProperty
    String entityType;

    @JsonProperty
    List<RoutePoint> geocodePoints;

    @JsonProperty
    List<String> matchCodes;

    Leg.Location toLocation() {
        Leg.Location loc = new Leg.Location();

        loc.setBoundingBox(new BoundingBox(bbox[0], bbox[1], bbox[2], bbox[3]));
        loc.setName(name);

        return loc;
    }

}
