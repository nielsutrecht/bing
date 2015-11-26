package com.nibado.bing.enums;

import java.util.HashMap;
import java.util.Map;

public enum ManeuverType {
    ARRIVE_FINISH("Arrive at the final destination."),
    ARRIVE_INTERMEDIATE("Arrive at an intermediate waypoint."),
    BEAR_LEFT("Bear left."),
    BEAR_LEFT_THEN_BEAR_LEFT("Bear left and then bear left again."),
    BEAR_LEFT_THEN_BEAR_RIGHT("Bear left and then bear right."),
    BEAR_LEFT_THEN_TURN_LEFT("Bear left and then turn left."),
    BEAR_LEFT_THEN_TURN_RIGHT("Bear left and then turn right."),
    BEAR_RIGHT("Bear right."),
    BEAR_RIGHT_THEN_BEAR_LEFT("Bear right and then bear left."),
    BEAR_RIGHT_THEN_BEAR_RIGHT("Bear right and then bear right again."),
    BEAR_RIGHT_THEN_TURN_LEFT("Bear right and then turn left."),
    BEAR_RIGHT_THEN_TURN_RIGHT("Bear right and then turn right."),
    BEAR_THEN_KEEP("Bear instruction and then a keep instruction"),
    BEAR_THEN_MERGE("Bear instruction and then a merge instruction."),
    CONTINUE("Continue on the current road."),
    DEPART_INTERMEDIATE_STOP("Leave an intermediate waypoint in a different direction and road than you arrived on."),
    DEPART_INTERMEDIATE_STOP_RETURNING("Leave an intermediate waypoint in the same direction and on the same road that you arrived on."),
    DEPART_START("Leave the starting point."),
    ENTER_ROUNDABOUT("Enter a roundabout."),
    EXIT_ROUNDABOUT("Exit a roundabout."),
    ENTER_THEN_EXIT_ROUNDABOUT("Enter and exit a roundabout."),
    KEEP_LEFT("Keep left onto a different road."),
    KEEP_ON_RAMP_LEFT("Keep left and continue onto ramp."),
    KEEP_ON_RAMP_RIGHT("Keep right and continue onto ramp."),
    KEEP_ON_RAMP_STRAIGHT("Keep straight and continue onto ramp."),
    KEEP_RIGHT("Keep right onto a different road."),
    KEEP_STRAIGHT("Keep straight onto a different road."),
    KEEP_TO_STAY_LEFT("Keep left to stay on the same road."),
    KEEP_TO_STAY_RIGHT("Keep right to stay on the same road."),
    KEEP_TO_STAY_STRAIGHT("Keep straight to stay on the same road."),
    MERGE("Merge onto a highway."),
    NONE("No instruction."),
    RAMP_THEN_HIGHWAY_LEFT("Take left ramp onto highway. This is part of a combined instruction."),
    RAMP_THEN_HIGHWAY_RIGHT("Take right ramp onto highway. This is part of a combined instruction."),
    RAMP_THEN_HIGHWAY_STRAIGHT("Stay straight to take ramp onto highway. This is part of a combined instruction."),
    ROAD_NAME_CHANGE("Road name changes."),
    TAKE("Take the road. This instruction is used when you are entering or exiting a ferry."),
    TAKE_RAMP_LEFT("Take ramp to the left."),
    TAKE_RAMP_RIGHT("Take ramp to the right."),
    TAKE_RAMP_STRAIGHT("Stay straight to take ramp."),
    TAKE_TRANSIT("Take transit."),
    TRANSFER("Transfer between public transit at transit stop."),
    TRANSIT_ARRIVE("Get off public transit at transit stop."),
    TRANSIT_DEPART("Get on public transit at transit stop."),
    TURN_BACK("Turn back sharply."),
    TURN_LEFT("Turn left."),
    TURN_LEFT_THEN_BEAR_LEFT("Turn left and then bear left."),
    TURN_LEFT_THEN_BEAR_RIGHT("Turn left and then bear right."),
    TURN_LEFT_THEN_TURN_LEFT("Turn left and then turn left again."),
    TURN_LEFT_THEN_TURN_RIGHT("Turn left and then turn right."),
    TURN_RIGHT("Turn right."),
    TURN_RIGHT_THEN_BEAR_LEFT("Turn right and then bear left."),
    TURN_RIGHT_THEN_BEAR_RIGHT("Turn right and then bear right."),
    TURN_RIGHT_THEN_TURN_LEFT("Turn right and then turn left."),
    TURN_RIGHT_THEN_TURN_RIGHT("Turn right and then turn right again"),
    TURN_THEN_MERGE("Turn instruction followed by a merge instruction."),
    TURN_TO_STAY_LEFT("Turn left to stay on the same road."),
    TURN_TO_STAY_RIGHT("Turn right to stay on the same road."),
    UNKNOWN("The instruction is unknown."),
    U_TURN("Make a u-turn to go in the opposite direction."),
    WAIT("Wait at a transit stop."),
    WALK("Walk.");

    private String description;

    ManeuverType(String description) {
        this.description = description;
    }

    public String getDescription() {
       return description;
    }

    public static ManeuverType from(String value) {
       return enumMap.get(value.toLowerCase());
    }

    private static Map<String, ManeuverType> enumMap = new HashMap<>();

    static {
        for(ManeuverType e : ManeuverType.values()) {
            enumMap.put(e.toString().toLowerCase().replace("_", ""), e);
        }
    }
}
