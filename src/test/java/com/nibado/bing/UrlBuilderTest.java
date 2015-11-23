package com.nibado.bing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UrlBuilderTest {
    @Test
    public void testUrlBuilder() {
        Bing.UrlBuilder build = new Bing.UrlBuilder();

        build.apiKey("MYKEY");
        build.wayPoint("WP1");
        build.viaWayPoint("WP2");
        build.wayPoint("WP3");

        RouteOptions options = new RouteOptions();
        options.maxSolutions(3);

        build.apply(options);

        assertThat(build.build())
                .contains("dev.virtualearth.net/REST/v1/Routes")
                .contains("key=MYKEY")
                .contains("maxSolns=3")
                .contains("wayPoint.1=WP1&viaWayPoint.2=WP2&wayPoint.3=WP3");
    }
}
