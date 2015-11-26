package com.nibado.bing.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibado.bing.BoundingBox;
import com.nibado.bing.Leg;
import com.nibado.bing.Route;
import com.nibado.bing.RouteResponse;
import com.nibado.bing.enums.DistanceUnit;
import com.nibado.bing.enums.DurationUnit;
import com.nibado.bing.enums.TrafficCongestion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDeserializer {
    private static final Logger LOG = LoggerFactory.getLogger(ResultDeserializer.class);
    private ObjectMapper mapper = new ObjectMapper();

    public RouteResponse deserilize(InputStream ins) throws IOException {
        Envelope env = mapper.readValue(ins, Envelope.class);

        if (env.getStatusCode() == 200) {
            LOG.debug("Got envelope with {} routes", env.getResourceSets().get(0).resources.size());
            List<Route> routes = env.getResourceSets().get(0).resources.stream()
                    .filter(r -> r.type.startsWith("Route:"))
                    .map(ResultDeserializer::toRoute)
                    .collect(Collectors.toList());

            return new RouteResponse(env.getStatusDescription(), routes);
        } else {
            LOG.warn("Got response code {} with message {}", env.getStatusCode(), env.getStatusDescription());
            return new RouteResponse(env.getStatusCode(), env.getStatusDescription(), env.getErrorDetails());
        }
    }

    private static Route toRoute(Resource resource) {
        Route route = new Route();

        route.setBoundingBox(new BoundingBox(resource.boundingBox[0], resource.boundingBox[1], resource.boundingBox[2], resource.boundingBox[3]));
        route.setDistanceUnit(DistanceUnit.valueOf(resource.distanceUnit.toUpperCase()));
        route.setDurationUnit(DurationUnit.valueOf(resource.durationUnit.toUpperCase()));
        route.setTrafficCongestion(TrafficCongestion.valueOf(resource.trafficCongestion.toUpperCase()));
        route.setTravelDistance(resource.travelDistance);
        route.setTravelDuration(resource.travelDuration);
        route.setTravelDurationTraffic(resource.travelDurationTraffic);

        route.setLegs(resource.routeLegs.stream().map(RouteLeg::toLeg).collect(Collectors.toList()));

        return route;
    }
}
