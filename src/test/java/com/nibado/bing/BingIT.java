package com.nibado.bing;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class BingIT {
    private Bing bing;

    @Before
    public void setup() {
        bing = new Bing(TestConfig.get().apiKey());
    }

    @Test
    public void testRoute() throws IOException {
        RouteOptions options = new RouteOptions();
        options.maxSolutions(3);
        RouteResponse response = bing.getRoute(options, "Copenhagen", "Barcelona");

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getRoutes().size()).isGreaterThan(0).isLessThan(4);
        assertThat(response.getRoutes().get(0).getTravelDistance()).isGreaterThan(2000.0).isLessThan(3000.0);
        assertThat(response.getRoutes().get(0).getTravelDuration()).isGreaterThan(50000).isLessThan(80000);
    }
}