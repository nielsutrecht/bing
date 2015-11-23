package com.nibado.bing.response;

import com.nibado.bing.RouteResponse;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultDeserializerTest {
    @Test
    public void testDeserializer() throws Exception {
        RouteResponse response = new ResultDeserializer().deserilize(ResultDeserializerTest.class.getResourceAsStream("/ams-utr.json"));

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getStatusDescription()).isEqualTo("OK");
        assertThat(response.getRoutes().size()).isEqualTo(3);

    }
}