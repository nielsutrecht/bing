package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonProperty;

class RouteAddress {
    @JsonProperty
    String adminDistrict;

    @JsonProperty
    String adminDistrict2;

    @JsonProperty
    String countryRegion;

    @JsonProperty
    String formattedAddress;

    @JsonProperty
    String locality;
}
