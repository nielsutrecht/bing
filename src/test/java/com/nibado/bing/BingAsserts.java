package com.nibado.bing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BingAsserts {
    public static void assertOk(RouteResponse response, int size) {
        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getStatusDescription()).isEqualTo("OK");
        assertThat(response.getRoutes().size()).isEqualTo(size);
    }

    public static void assertTravel(RouteResponse response, int index, double distance, int duration, int durationTraffic) {
        Route r = response.getRoutes().get(index);

        assertThat(r.getTravelDistance()).isEqualTo(distance);
        assertThat(r.getTravelDuration()).isEqualTo(duration);
        assertThat(r.getTravelDurationTraffic()).isEqualTo(durationTraffic);
    }

    public static void assertStartFinish(RouteResponse response, String start, String end) {
        response.getRoutes().forEach(r -> {
            assertThat(r.getLegs().get(0).getStartLocation().getName()).contains(start);
            assertThat(r.getLegs().get(0).getEndLocation().getName()).contains(end);
        });
    }
}
