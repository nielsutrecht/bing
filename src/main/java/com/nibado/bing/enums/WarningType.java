package com.nibado.bing.enums;

import java.util.HashMap;
import java.util.Map;

public enum WarningType {
    ACCIDENT("There is a traffic accident."),
    ADMIN_DIVISION_CHANGE("The route has left one administrative division and entered another."),
    BLOCKED_ROAD("The road is closed or blocked."),
    CHECK_TIMETABLE("Check a time table. This usually refers to a ferry or Autorail time table."),
    CONGESTION("The traffic is slow."),
    COUNTRY_CHANGE("The route has left one country and entered another."),
    DISABLED_VEHICLE("There is a disabled vehicle."),
    GATE_ACCESS("A gate blocks the road and access is required to continue along the route."),
    GET_OFF_TRANSIT("Get off the transit at this location."),
    GET_ON_TRANSIT("Get on the transit at this location."),
    ILLEGAL_U_TURN("A U-turn is illegal at this location."),
    MASS_TRANSIT("There is mass transit incident."),
    MISCELLANEOUS("A miscellaneous warning is available for this location."),
    NO_INCIDENT("There is no incident at this location."),
    NONE("There is no warning at this location."),
    OTHER("There is a warning at this location that cannot be classified as any other type of warning."),
    OTHER_NEWS("There is additional traffic incident information."),
    OTHER_TRAFFIC_INCIDENTS("There are other traffic incidents at this location."),
    PLANNED_EVENTS("There are scheduled events in the area."),
    PRIVATE_ROAD("The road being travelled on is private."),
    RESTRICTED_TURN("The turn may be restricted."),
    ROAD_CLOSURES("There are road closures at this location."),
    ROAD_HAZARD("There is a road hazard."),
    SCHEDULED_CONSTRUCTION("There is construction along the route. The ScheduledConstruction value is used for any type of construction and not just construction that has specific start and end dates."),
    SEASONAL_CLOSURES("A seasonal closure occurs at this location."),
    TOLLBOOTH("A toll is required at this location to continue along the route."),
    TOLL_ROAD("The road is a toll road."),
    TOLL_ZONE_ENTER("The entrance to a toll zone."),
    TOLL_ZONE_EXIT("The exit of a toll zone."),
    TRAFFIC_FLOW("The warning is about traffic flow."),
    TRANSIT_LINE_CHANGE("There is a transit line change but a change of vehicle is not required."),
    UNPAVED_ROAD("The road is unpaved."),
    WEATHER("There is significant weather at this location.");

    private String description;

    WarningType(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
    }

    public static WarningType from(String value) {
       return enumMap.get(value.toLowerCase());
    }

    private static Map<String, WarningType> enumMap = new HashMap<>();

    static {
        for(WarningType e : WarningType.values()) {
            enumMap.put(e.toString().toLowerCase().replace("_", ""), e);
        }
    }
}
