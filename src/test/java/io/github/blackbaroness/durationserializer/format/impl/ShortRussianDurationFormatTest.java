package io.github.blackbaroness.durationserializer.format.impl;

import io.github.blackbaroness.durationserializer.DurationFormats;
import io.github.blackbaroness.durationserializer.format.DurationFormat;
import io.github.blackbaroness.durationserializer.format.DurationUnit;
import io.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortRussianDurationFormatTest {

    private final DurationFormat format = DurationFormats.shortRussian();

    @Test
    void serialize() {
        assertEquals("1 нс", format.serialize(DurationUnit.NANOSECONDS, 1));
        assertEquals("1 мс", format.serialize(DurationUnit.MILLISECONDS, 1));
        assertEquals("1 с", format.serialize(DurationUnit.SECONDS, 1));
        assertEquals("1 м", format.serialize(DurationUnit.MINUTES, 1));
        assertEquals("1 ч", format.serialize(DurationUnit.HOURS, 1));
        assertEquals("1 д", format.serialize(DurationUnit.DAYS, 1));
    }

    @Test
    void deserialize() throws InvalidFormatException {
        assertEquals(Duration.ofNanos(1), format.deserialize("нс", 1));
        assertEquals(Duration.ofMillis(1), format.deserialize("мс", 1));
        assertEquals(Duration.ofSeconds(1), format.deserialize("с", 1));
        assertEquals(Duration.ofMinutes(1), format.deserialize("м", 1));
        assertEquals(Duration.ofHours(1), format.deserialize("ч", 1));
        assertEquals(Duration.ofDays(1), format.deserialize("д", 1));
    }
}
