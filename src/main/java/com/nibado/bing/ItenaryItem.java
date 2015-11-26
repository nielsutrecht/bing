package com.nibado.bing;

import com.nibado.bing.enums.CompassDirection;
import com.nibado.bing.enums.TravelMode;
import com.nibado.bing.enums.WarningType;

import java.util.List;

public class ItenaryItem {
    private final CompassDirection compassDirection;
    private final TravelMode travelMode;
    private final String exit;
    private final double travelDistance;
    private final int travelDuration;
    private final List<Detail> details;
    private final Instruction instruction;
    private final String sideOfStreet;
    private final String tollZone;
    private final String towardsRoadName;
    private final String transitTerminus;
    private final List<Warning> warnings;
    private final List<Hint> hints;


    public ItenaryItem(CompassDirection compassDirection, TravelMode travelMode, String exit, double travelDistance, int travelDuration, List<Detail> details, Instruction instruction, String sideOfStreet, String tollZone, String towardsRoadName, String transitTerminus, List<Warning> warnings, List<Hint> hints) {
        this.compassDirection = compassDirection;
        this.travelMode = travelMode;
        this.exit = exit;
        this.travelDistance = travelDistance;
        this.travelDuration = travelDuration;
        this.details = details;
        this.instruction = instruction;
        this.sideOfStreet = sideOfStreet;
        this.tollZone = tollZone;
        this.towardsRoadName = towardsRoadName;
        this.transitTerminus = transitTerminus;
        this.warnings = warnings;
        this.hints = hints;
    }

    public CompassDirection getCompassDirection() {
        return compassDirection;
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public String getExit() {
        return exit;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public int getTravelDuration() {
        return travelDuration;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public String getSideOfStreet() {
        return sideOfStreet;
    }

    public String getTollZone() {
        return tollZone;
    }

    public String getTowardsRoadName() {
        return towardsRoadName;
    }

    public String getTransitTerminus() {
        return transitTerminus;
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    public static class Detail {
        private final int compassDegrees;
        private final String maneuverType;
        private final TravelMode travelMode;
        private final List<String> names;
        private final List<String> locationCodes;
        private final String roadType;

        public Detail(int compassDegrees, String maneuverType, TravelMode travelMode, List<String> names, List<String> locationCodes, String roadType) {
            this.compassDegrees = compassDegrees;
            this.maneuverType = maneuverType;
            this.travelMode = travelMode;
            this.names = names;
            this.locationCodes = locationCodes;
            this.roadType = roadType;
        }

        public int getCompassDegrees() {
            return compassDegrees;
        }

        public String getManeuverType() {
            return maneuverType;
        }

        public TravelMode getTravelMode() {
            return travelMode;
        }

        public List<String> getNames() {
            return names;
        }

        public List<String> getLocationCodes() {
            return locationCodes;
        }

        public String getRoadType() {
            return roadType;
        }
    }

    public static class Instruction {
        private final String formattedText;
        private final String maneuverType;
        private final String text;

        public Instruction(String formattedText, String maneuverType, String text) {
            this.formattedText = formattedText;
            this.maneuverType = maneuverType;
            this.text = text;
        }

        public String getFormattedText() {
            return formattedText;
        }

        public String getManeuverType() {
            return maneuverType;
        }

        public String getText() {
            return text;
        }
    }

    public static class Warning {
        private final String severity;
        private final String text;
        private final WarningType warningType;
        private final String origin;
        private final String to;

        public Warning(String severity, String text, WarningType warningType, String origin, String to) {
            this.severity = severity;
            this.text = text;
            this.warningType = warningType;
            this.origin = origin;
            this.to = to;
        }

        public String getSeverity() {
            return severity;
        }

        public String getText() {
            return text;
        }

        public WarningType getWarningType() {
            return warningType;
        }

        public String getOrigin() {
            return origin;
        }

        public String getTo() {
            return to;
        }
    }

    public static class Hint {
        private final String hintType;
        private final String text;

        public Hint(String hintType, String text) {
            this.hintType = hintType;
            this.text = text;
        }

        public String getHintType() {
            return hintType;
        }

        public String getText() {
            return text;
        }
    }
}
