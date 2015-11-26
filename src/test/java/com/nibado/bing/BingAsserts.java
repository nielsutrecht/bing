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
    public static void assertLegs(RouteResponse response, String... locations) {
        response.getRoutes().forEach(r -> {
            double distance = 0.0;
            int duration = 0;

            assertThat(r.getLegs().size()).isEqualTo(locations.length - 1);

            for(int i = 0;i < r.getLegs().size();i++) {
                Leg l = r.getLegs().get(i);
                distance += l.getTravelDistance();
                duration += l.getTravelDuration();

                assertThat(l.getStartLocation().getName()).contains(locations[i]);
                assertThat(l.getEndLocation().getName()).contains(locations[i + 1]);
            }

            assertThat(r.getTravelDistance()).isEqualTo(distance);
            assertThat(r.getTravelDuration()).isEqualTo(duration);
        });
    }
}
