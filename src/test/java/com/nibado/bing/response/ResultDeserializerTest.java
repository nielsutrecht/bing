package com.nibado.bing.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nibado.bing.ItenaryItem;
import com.nibado.bing.Leg;
import com.nibado.bing.RouteResponse;
import com.nibado.bing.enums.CompassDirection;
import com.nibado.bing.enums.ManeuverType;
import com.nibado.bing.enums.TravelMode;
import com.nibado.bing.enums.WarningType;
import org.junit.Test;

import java.io.IOException;

import static com.nibado.bing.BingAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultDeserializerTest {
    @Test
    public void testDeserializer() throws Exception {
        RouteResponse response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/ams-utr.json"));
        assertOk(response, 3);
        assertTravel(response, 0, 40.805, 2281, 2966);
        assertTravel(response, 1, 53.098, 2431, 2772);
        assertTravel(response, 2, 44.252, 2756, 3453);
        assertLegs(response, "Amsterdam", "Utrecht");

        response.getRoutes().forEach(r -> {
            assertThat(r.getLegs()).extracting(l -> l.getRegion()).containsOnly("EU");
            assertThat(r.getLegs()).extracting(l -> l.getDescription()).doesNotContainNull();
        });

        response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/cop-bar.json"));
        assertOk(response, 3);
        assertTravel(response, 0, 2150.95, 69568, 81821);
        assertTravel(response, 1, 2268.548, 74034, 86092);
        assertTravel(response, 2, 2515.1, 84194, 98983);
        assertLegs(response, "Copenhagen", "Barcelona");

        response.getRoutes().forEach(r -> {
            assertThat(r.getLegs()).extracting(l -> l.getRegion()).containsOnly("EU");
            assertThat(r.getLegs()).extracting(l -> l.getDescription()).doesNotContainNull();
        });

        response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/ny-la-wa.json"));
        assertOk(response, 3);
        assertTravel(response, 0, 8767.361, 284409, 303261);
        assertTravel(response, 1, 8850.955, 287717, 306469);
        assertTravel(response, 2, 9288.067, 299028, 317371);
        assertLegs(response, "New York", "Los Angeles", "Washington");

        response.getRoutes().forEach(r -> {
            assertThat(r.getLegs()).extracting(l -> l.getRegion()).containsOnly("NAv2");
            assertThat(r.getLegs()).extracting(l -> l.getDescription()).doesNotContainNull();
        });

        Leg leg = response.getRoutes().get(0).getLegs().get(0);

        assertThat(leg.getDescription()).contains("I-80 W");
        assertThat(leg.getItenaryItems().size()).isEqualTo(36);
        assertThat(leg.getTravelDuration()).isEqualTo(146134);
        assertThat(leg.getTravelDistance()).isEqualTo(4512.66);

        assertThat(leg.getItenaryItems()).extracting(i -> i.getTravelMode()).containsOnly(TravelMode.DRIVING);

        ItenaryItem item = leg.getItenaryItems().get(0);
        assertThat(item.getCompassDirection()).isEqualTo(CompassDirection.EAST);
        assertThat(item.getDetails().size()).isEqualTo(1);
        assertThat(item.getDetails().get(0).getCompassDegrees()).isEqualTo(90);
        assertThat(item.getTravelDistance()).isEqualTo(0.168);
        assertThat(item.getTravelDuration()).isEqualTo(77);
        assertThat(item.getTowardsRoadName()).isEqualTo("20th Ave");
        assertThat(item.getInstruction().getManeuverType()).isEqualTo(ManeuverType.DEPART_START);
        assertThat(item.getInstruction().getText()).contains("Depart from");
        assertThat(item.getDetails().get(0).getManeuverType()).isEqualTo(ManeuverType.DEPART_START);
        assertThat(item.getDetails().get(0).getTravelMode()).isEqualTo(TravelMode.DRIVING);
        assertThat(item.getDetails().get(0).getRoadType()).isEqualTo("Street");
        assertThat(item.getWarnings().get(0).getWarningType()).isEqualTo(WarningType.PRIVATE_ROAD);

        serializeResponse(response);
    }

    @Test
    public void test404() throws Exception {
        RouteResponse response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/404.json"));

        assertThat(response.getStatusCode()).isEqualTo(404);
        assertThat(response.getStatusDescription()).contains("Not Found");
        assertThat(response.getErrorDetails().size()).isEqualTo(3);
    }

    private void serializeResponse(RouteResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(System.out, response);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}