package com.nibado.bing;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class UrlBuilderTest {
    @Test
    public void testUrlBuilder() {
        Bing.UrlBuilder build = new Bing.UrlBuilder();

        build.apiKey("MYKEY");
        build.wayPoint("WP1");
        build.viaWayPoint("WP2");
        build.viaWayPoint("WP SPACE 3");
        build.wayPoint("WP4");

        RouteOptions options = new RouteOptions();
        options.maxSolutions(3);

        build.apply(options);

        String url = build.build();

        assertThat(url)
                .contains("dev.virtualearth.net/REST/v1/Routes")
                .contains("key=MYKEY")
                .contains("maxSolns=3")
                .contains("wayPoint.1=WP1&viaWayPoint.2=WP2&viaWayPoint.3=WP+SPACE+3&wayPoint.4=WP4");

        assertValidUrl(url);
    }

    private void assertValidUrl(String url) {
        try {
            new URI(url);
        } catch (URISyntaxException e) {
            fail("Invalid URL: " + e.getMessage());
        }
    }
}
