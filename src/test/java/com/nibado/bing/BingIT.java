package com.nibado.bing;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


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
        RouteResponse response = bing.getRoute(options, "Groningen", "Leeuwarden");

        assertThat(response.getStatusCode()).isEqualTo(200);
    }
}