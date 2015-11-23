package com.nibado.bing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class RouteResponse {
    private final int statusCode;
    private final String statusDescription;
    private final List<Route> routes;

    public RouteResponse(int statusCode, String statusDescription, List<Route> routes) {
        this.statusCode  = statusCode;
        this.statusDescription = statusDescription;
        this.routes = routes;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
