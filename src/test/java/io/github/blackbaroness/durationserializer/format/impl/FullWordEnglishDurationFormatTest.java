package io.github.blackbaroness.durationserializer.format.impl;

import io.github.blackbaroness.durationserializer.DurationFormats;
import io.github.blackbaroness.durationserializer.format.DurationFormat;
import io.github.blackbaroness.durationserializer.format.DurationUnit;
import io.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullWordEnglishDurationFormatTest {

    private final DurationFormat format = DurationFormats.fullWordEnglish();

    @Test
    void serialize() {
        assertEquals("1 nanoseconds", format.serialize(DurationUnit.NANOSECONDS, 1));
        assertEquals("1 milliseconds", format.serialize(DurationUnit.MILLISECONDS, 1));
        assertEquals("1 seconds", format.serialize(DurationUnit.SECONDS, 1));
        assertEquals("1 minutes", format.serialize(DurationUnit.MINUTES, 1));
        assertEquals("1 hours", format.serialize(DurationUnit.HOURS, 1));
        assertEquals("1 days", format.serialize(DurationUnit.DAYS, 1));
    }

    @Test
    void deserialize() throws InvalidFormatException {
        assertEquals(Duration.ofNanos(1), format.deserialize("nanoseconds", 1));
        assertEquals(Duration.ofMillis(1), format.deserialize("milliseconds", 1));
        assertEquals(Duration.ofSeconds(1), format.deserialize("seconds", 1));
        assertEquals(Duration.ofMinutes(1), format.deserialize("minutes", 1));
        assertEquals(Duration.ofHours(1), format.deserialize("hours", 1));
        assertEquals(Duration.ofDays(1), format.deserialize("days", 1));
    }
}
