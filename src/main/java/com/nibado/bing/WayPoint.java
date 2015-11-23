package com.nibado.bing;

public class WayPoint {
    private final String wayPoint;
    private final boolean isVia;

    public WayPoint(String wayPoint) {
        this(wayPoint, false);
    }

    public WayPoint(String wayPoint, boolean isVia) {
        this.wayPoint = wayPoint;
        this.isVia = isVia;
    }

    public String getWayPoint() {
        return wayPoint;
    }

    public boolean isVia() {
        return isVia;
    }
}
