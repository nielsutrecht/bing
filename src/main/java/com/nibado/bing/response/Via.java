package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonProperty;

class Via {
    @JsonProperty
    String name;

    @JsonProperty
    String confidence;

    @JsonProperty
    String entityType;

    @JsonProperty
    RoutePoint point;
}
