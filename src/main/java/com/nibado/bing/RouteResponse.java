package com.nibado.bing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.List;

public class RouteResponse {
    private final int statusCode;
    private final String statusDescription;
    private final List<Route> routes;
    private final List<String> errorDetails;

    private RouteResponse(int statusCode, String statusDescription, List<Route> routes, List<String> errorDetails) {
        this.statusCode  = statusCode;
        this.statusDescription = statusDescription;
        this.routes = routes;
        this.errorDetails = errorDetails;
    }

    public RouteResponse(String statusDescription, List<Route> routes) {
        this(200, statusDescription, routes, Collections.emptyList());
    }

    public RouteResponse(int statusCode, String statusDescription, List<String> errorDetails) {
        this(statusCode, statusDescription, Collections.emptyList(), errorDetails);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public List<String> getErrorDetails() {
        return errorDetails;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
