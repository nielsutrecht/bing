package com.nibado.bing;

import java.time.Duration;
import java.util.Locale;

public class Util {
    private Util() {
    }

    public static String formatDuration(long seconds) {
        return formatDuration(Duration.ofSeconds(seconds));
    }

    public static String formatDuration(Duration duration) {
        return String.format(Locale.ROOT, "%s hours, %s minutes", duration.toHours(), duration.toMinutes() % (duration.toHours() * 60));
    }
}
