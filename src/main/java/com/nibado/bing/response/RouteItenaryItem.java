package com.nibado.bing.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nibado.bing.ItenaryItem;
import com.nibado.bing.LatLon;
import com.nibado.bing.enums.CompassDirection;
import com.nibado.bing.enums.ManeuverType;
import com.nibado.bing.enums.TravelMode;
import com.nibado.bing.enums.WarningType;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class RouteItenaryItem {
    @JsonProperty
    String compassDirection;

    @JsonProperty
    List<Detail> details;

    @JsonProperty
    String exit;

    @JsonProperty
    String iconType;

    @JsonProperty
    Instruction instruction;

    @JsonProperty
    RoutePoint maneuverPoint;

    @JsonProperty
    String sideOfStreet;

    @JsonProperty
    List<String> signs;

    @JsonProperty
    String tollZone;

    @JsonProperty
    String towardsRoadName;

    @JsonProperty
    String transitTerminus;

    @JsonProperty
    double travelDistance;

    @JsonProperty
    int travelDuration;

    @JsonProperty
    String travelMode;

    @JsonProperty
    List<Warning> warnings;

    @JsonProperty
    List<Hint> hints;

    ItenaryItem toItenaryItem() {
        List<ItenaryItem.Detail> detailList = details.stream().map(Detail::toDetail).collect(Collectors.toList());
        List<ItenaryItem.Hint> hintList = hints == null ? Collections.emptyList() : hints.stream().map(Hint::toHint).collect(Collectors.toList());
        List<ItenaryItem.Warning> warningList = warnings == null ? Collections.emptyList() : warnings.stream().map(Warning::toWarning).collect(Collectors.toList());

        ItenaryItem item = new ItenaryItem(CompassDirection.from(compassDirection),
                TravelMode.from(travelMode),
                exit,
                travelDistance,
                travelDuration,
                detailList,
                instruction.toInstruction(),
                sideOfStreet,
                tollZone,
                towardsRoadName,
                transitTerminus,
                warningList,
                hintList);

        return item;
    }

    static class Detail {
        @JsonProperty
        int compassDegrees;

        @JsonProperty
        int[] endPathIndices;

        @JsonProperty
        String maneuverType;

        @JsonProperty
        String mode;

        @JsonProperty
        List<String> names;

        @JsonProperty
        List<String> locationCodes;

        @JsonProperty
        String roadType;

        @JsonProperty
        int[] startPathIndices;

        @JsonProperty
        RoadShieldRequestParameters roadShieldRequestParameters;

        public ItenaryItem.Detail toDetail() {
            return new ItenaryItem.Detail(compassDegrees, ManeuverType.from(maneuverType), TravelMode.from(mode), names, locationCodes, roadType);
        }
    }

    static class Instruction {
        @JsonProperty
        String formattedText;

        @JsonProperty
        String maneuverType;

        @JsonProperty
        String text;

        ItenaryItem.Instruction toInstruction() {
            return new ItenaryItem.Instruction(formattedText, ManeuverType.from(maneuverType), text);
        }
    }

    static class RoadShieldRequestParameters {
        @JsonProperty
        int bucket;

        @JsonProperty
        List<Shield> shields;
    }

    static class Shield {
        @JsonProperty
        List<String> labels;

        @JsonProperty(value = "roadShieldType")
        int type;
    }

    static class Warning {
        @JsonProperty
        String severity;

        @JsonProperty
        String text;

        @JsonProperty
        String warningType;

        @JsonProperty
        String origin;

        @JsonProperty
        String to;

        ItenaryItem.Warning toWarning() {
            return new ItenaryItem.Warning(severity, text, WarningType.from(warningType), LatLon.from(origin), LatLon.from(to));
        }
    }

    static class Hint {
        @JsonProperty
        String hintType;

        @JsonProperty
        String text;

        ItenaryItem.Hint toHint() {
            return new ItenaryItem.Hint(hintType, text);
        }
    }
}
