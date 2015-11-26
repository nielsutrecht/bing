package com.nibado.bing.enums;

import java.util.HashMap;
import java.util.Map;

public enum CompassDirection {
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST;

    public static CompassDirection from(String compassDirection) {
        return compassDirectionMap.get(compassDirection.toLowerCase());
    }

    private static Map<String, CompassDirection> compassDirectionMap = new HashMap<>();

    static {
        for(CompassDirection dir : CompassDirection.values()) {
            compassDirectionMap.put(dir.toString().toLowerCase().replace("_", ""), dir);
        }
    }
}
