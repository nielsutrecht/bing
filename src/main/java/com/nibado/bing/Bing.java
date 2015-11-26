package com.nibado.bing;

import com.nibado.bing.enums.DistanceUnit;
import com.nibado.bing.response.ResultDeserializer;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bing {
    private static final RouteOptions DEFAULT_OPTIONS = new RouteOptions();
    private static final Logger LOG = LoggerFactory.getLogger(Bing.class);

    private RouteOptions options;
    private String apiKey;

    public Bing(String apiKey) {
        this.apiKey = apiKey;
        this.options = DEFAULT_OPTIONS;
    }

    public RouteResponse getRoute(WayPoint... wayPoints) throws IOException {
        return getRoute(options, wayPoints);
    }

    public RouteResponse getRoute(RouteOptions options, WayPoint... wayPoints) throws IOException {
        return getRoute(options, Arrays.asList(wayPoints));
    }

    public RouteResponse getRoute(List<WayPoint> wayPoints) throws IOException {
        return getRoute(options, wayPoints);
    }

    public RouteResponse getRoute(RouteOptions options, List<WayPoint> wayPoints) throws IOException {
        String url = new UrlBuilder()
                .wayPoints(wayPoints)
                .apply(options)
                .apiKey(apiKey)
                .build();

        return request(url);
    }

    public RouteResponse getRoute(String... wayPoints) throws IOException {
        return getRoute(options, wayPoints);
    }

    public RouteResponse getRoute(RouteOptions options, String... wayPoints) throws IOException {
        UrlBuilder builder = new UrlBuilder();

        for(String wp : wayPoints) {
            builder.wayPoint(wp);
        }

        String url = builder.apply(options)
                .apiKey(apiKey)
                .build();

        return request(url);
    }

    private RouteResponse request(String url) throws IOException {
        LOG.debug("URL: {}", url);
        InputStream ins = Request.Get(url).execute().returnContent().asStream();

        return new ResultDeserializer().deserilize(ins);
    }

    static class UrlBuilder {
        private static String URL_BASE = "http://dev.virtualearth.net/REST/v1/Routes";
        private StringBuilder current;
        private boolean empty = true;
        private boolean hasApiKey = false;
        private List<WayPoint> wayPoints;

        UrlBuilder() {
            current = new StringBuilder(URL_BASE);
            wayPoints = new ArrayList<>(2);
        }

        public UrlBuilder wayPoint(String wayPoint) {
            wayPoints.add(new WayPoint(wayPoint));

            return this;
        }

        public UrlBuilder viaWayPoint(String wayPoint) {
            wayPoints.add(new WayPoint(wayPoint, true));

            return this;
        }

        public UrlBuilder wayPoints(List<WayPoint> wayPoints) {
            for(WayPoint wp : wayPoints) {
                this.wayPoints.add(wp);
            }

            return this;
        }

        public UrlBuilder apiKey(String apiKey) {
            addSeparator();
            current.append("key=");
            current.append(apiKey);

            hasApiKey = true;

            return this;
        }

        public UrlBuilder apply(RouteOptions options) {
            if(options.avoidHighways || options.avoidTolls || options.minimizeHighways || options.minimizeTolls) {
                OptionList list = new OptionList();

                list
                        .addIf(options.avoidHighways, "highways")
                        .addIf(options.avoidTolls, "tolls")
                        .addIf(options.minimizeHighways, "minimizeHighways")
                        .addIf(options.minimizeTolls, "minimizeTolls");

                addSeparator();
                current.append("avoid=");
                current.append(list.build());
            }

            if(options.distanceBeforeFirstTurn >= 0) {
                addSeparator();
                current.append("dbft=");
                current.append(options.distanceBeforeFirstTurn);
            }

            if(options.heading >= 0) {
                addSeparator();
                current.append("hd=");
                current.append(options.heading);
            }

            if(options.optimize != null) {
                addSeparator();
                current.append("optimize=");
                current.append(options.optimize);
            }

            if(options.excludeItinerary || options.includeRoutePath || options.includeTransitStops || options.routeSummariesOnly) {
                OptionList list = new OptionList();

                list
                        .addIf(options.excludeItinerary, "excludeItinerary")
                        .addIf(options.includeRoutePath, "routePath")
                        .addIf(options.includeTransitStops, "transitStops")
                        .addIf(options.routeSummariesOnly, "routeSummariesOnly");

                addSeparator();
                current.append("routeAttributes=");
                current.append(list.build());
            }

            if(options.tolerances != null) {
                OptionList list = new OptionList();

                for(double d : options.tolerances) {
                    list.add(Double.toString(d));
                }

                addSeparator();
                current.append("tolerances=");
                current.append(list.build());
            }

            if(options.distanceUnit == DistanceUnit.MILE) {
                addSeparator();
                current.append("du=mi");
            }

            if(options.dateTime != null) {
                addSeparator();
                current.append("dateTime=");
                current.append(options.dateTime);
            }

            if(options.timeType != null) {
                addSeparator();
                current.append("tt=");
                current.append(options.timeType);
            }

            if(options.maxSolutions >= 1) {
                addSeparator();
                current.append("maxSolns=");
                current.append(options.maxSolutions);
            }

            if(options.travelMode != null) {
                addSeparator();
                current.append("travelMode=");
                current.append(options.travelMode);
            }

            return this;
        }

        public String build() {
            addWaypoints();

            return current.toString();
        }

        private void addSeparator() {
            current.append(empty ? '?' : '&');
            empty = false;
        }

        private void addWaypoints() {
            int index = 0;
            for(WayPoint wp : wayPoints) {
                addSeparator();
                if(wp.isVia()) {
                    current.append("viaWayPoint.");
                }
                else {
                    current.append("wayPoint.");
                }
                current.append(++index);
                current.append('=');

                current.append(urlEncode(wp));
            }
        }

        private static String urlEncode(WayPoint wayPoint) {
            try {
                return URLEncoder.encode(wayPoint.getWayPoint(), "UTF-8");
            }
            catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        private static class OptionList {
            private List<String> options = new ArrayList<>(4);

            public OptionList add(String option) {
                options.add(option);

                return this;
            }

            public OptionList addIf(boolean condition, String option) {
                if(condition) {
                    options.add(option);
                }

                return this;
            }

            public String build() {
                StringBuilder builder = new StringBuilder();

                for(String s : options) {
                    if(builder.length() > 0) {
                        builder.append(',');
                    }
                    builder.append(s);
                }

                return builder.toString();
            }
        }
    }
}
