package com.nibado.bing.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nibado.bing.RouteResponse;
import org.junit.Test;

import java.io.IOException;

import static com.nibado.bing.BingAsserts.assertOk;
import static com.nibado.bing.BingAsserts.assertStartFinish;
import static com.nibado.bing.BingAsserts.assertTravel;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultDeserializerTest {
    @Test
    public void testDeserializer() throws Exception {
        RouteResponse response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/ams-utr.json"));
        assertOk(response, 3);
        assertTravel(response, 0, 40.805, 2281, 2966);
        assertTravel(response, 1, 53.098, 2431, 2772);
        assertTravel(response, 2, 44.252, 2756, 3453);
        assertStartFinish(response, "Amsterdam", "Utrecht");

        response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/cop-bar.json"));
        assertOk(response, 3);
        assertTravel(response, 0, 2150.95, 69568, 81821);
        assertTravel(response, 1, 2268.548, 74034, 86092);
        assertTravel(response, 2, 2515.1, 84194, 98983);
        assertStartFinish(response, "Copenhagen", "Barcelona");
        //serializeResponse(response);
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