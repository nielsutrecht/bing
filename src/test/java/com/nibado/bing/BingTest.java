package com.nibado.bing;

import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BingTest {
    private Bing bing;

    @Before
    public void setup() {
        bing = new Bing(TestConfig.get().apiKey());
    }

    @Test
    public void testRoute() {
        bing.getRoute("Amsterdam", "Utrecht");
    }
}