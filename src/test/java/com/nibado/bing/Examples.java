package com.nibado.bing;

public class Examples {
    public static void main(String... argv) throws Exception {
        String apiKey = TestConfig.get().apiKey();

        new Bing(apiKey)
                .getRoute("Amsterdam", "Paris")
                .getRoutes()
                .forEach(System.out::println);

        new Bing(apiKey)
                .getRoute(new RouteOptions().maxSolutions(3), "Copenhagen", "Lisbon")
                .getRoutes()
                .forEach(System.out::println);
    }
}
