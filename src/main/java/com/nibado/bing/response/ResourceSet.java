package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class ResourceSet {
    @JsonProperty(required = true, value = "estimatedTotal")
    int estimatedTotal;
    @JsonProperty(required = true, value = "resources")
    List<Resource> resources;
}
