package com.nibado.bing.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibado.bing.BoundingBox;
import com.nibado.bing.Route;
import com.nibado.bing.RouteResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDeserializer {
    private ObjectMapper mapper = new ObjectMapper();

    public RouteResponse deserilize(InputStream ins) throws IOException {
        Envelope env = mapper.readValue(ins, Envelope.class);

        if(env.getStatusCode() == 200) {
            List<Route> routes = env.getResourceSets().get(0).resources.stream()
                    .filter(r -> r.type.startsWith("Route:"))
                    .map(ResultDeserializer::toRoute)
                    .collect(Collectors.toList());

            return new RouteResponse(env.getStatusCode(), env.getStatusDescription(), routes);
        }
        else {
            return new RouteResponse(env.getStatusCode(), env.getStatusDescription(), null);
        }
    }

    private static Route toRoute(Resource resource) {
        Route route = new Route();

        route.setBoundingBox(new BoundingBox(resource.boundingBox[0], resource.boundingBox[1], resource.boundingBox[2], resource.boundingBox[3]));
        route.setDistanceUnit(Route.DistanceUnit.valueOf(resource.distanceUnit.toUpperCase()));
        route.setDurationUnit(Route.DurationUnit.valueOf(resource.durationUnit.toUpperCase()));
        route.setTrafficCongestion(Route.TrafficCongestion.valueOf(resource.trafficCongestion.toUpperCase()));
        route.setTravelDistance(resource.travelDistance);
        route.setTravelDuration(resource.travelDuration);
        route.setTravelDurationTraffic(resource.travelDurationTraffic);

        return route;
    }
}
