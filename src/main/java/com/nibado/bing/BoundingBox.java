package com.nibado.bing;

public class BoundingBox {
    private LatLon from;
    private LatLon to;

    public BoundingBox(LatLon from, LatLon to) {
        this.from = from;
        this.to = to;
    }

    public BoundingBox(double fromLat, double fromLon, double toLat, double toLon) {
        this(new LatLon(fromLat, fromLon), new LatLon(toLat, toLon));
    }

    public LatLon getFrom() {
        return from;
    }

    public LatLon getTo() {
        return to;
    }
}
