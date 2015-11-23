# Bing Route API Java Wrapper

This is a Java Wrapper for the Bing maps API. 

## Example:

Getting the distance/time between Amsterdam and Paris:

```java
        new Bing("apiKey")
                .getRoute("Amsterdam", "Paris")
                .getRoutes()
                .forEach(System.out::println);
```

Getting the distance/time for multiple routes:

```java
        new Bing("apiKey")
                .getRoute(new RouteOptions().maxSolutions(3), "Copenhagen", "Lisbon")
                .getRoutes()
                .forEach(System.out::println);
```