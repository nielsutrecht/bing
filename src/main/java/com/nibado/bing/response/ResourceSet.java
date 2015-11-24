package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class ResourceSet {
    @JsonProperty
    int estimatedTotal;

    @JsonProperty
    List<Resource> resources;
}
