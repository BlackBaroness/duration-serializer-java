package com.github.blackbaroness.durationserializer.format.impl;

import com.github.blackbaroness.durationserializer.format.DurationUnit;
import com.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortEnglishDurationFormatTest {

    private final ShortEnglishDurationFormat format = new ShortEnglishDurationFormat();

    @Test
    void serialize() {
        assertEquals("1 ns", format.serialize(DurationUnit.NANOSECONDS, 1));
        assertEquals("1 ms", format.serialize(DurationUnit.MILLISECONDS, 1));
        assertEquals("1 s", format.serialize(DurationUnit.SECONDS, 1));
        assertEquals("1 min", format.serialize(DurationUnit.MINUTES, 1));
        assertEquals("1 h", format.serialize(DurationUnit.HOURS, 1));
        assertEquals("1 d", format.serialize(DurationUnit.DAYS, 1));
    }

    @Test
    void deserialize() throws InvalidFormatException {
        assertEquals(Duration.ofNanos(1), format.deserialize("ns", 1));
        assertEquals(Duration.ofMillis(1), format.deserialize("ms", 1));
        assertEquals(Duration.ofSeconds(1), format.deserialize("s", 1));
        assertEquals(Duration.ofMinutes(1), format.deserialize("min", 1));
        assertEquals(Duration.ofHours(1), format.deserialize("h", 1));
        assertEquals(Duration.ofDays(1), format.deserialize("d", 1));
    }
}