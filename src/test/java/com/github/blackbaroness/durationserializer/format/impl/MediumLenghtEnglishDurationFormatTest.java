package com.github.blackbaroness.durationserializer.format.impl;

import com.github.blackbaroness.durationserializer.format.DurationUnit;
import com.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediumLenghtEnglishDurationFormatTest {

    private final MediumLengthEnglishDurationFormat format = new MediumLengthEnglishDurationFormat();

    @Test
    void serialize() {
        assertEquals("1 nanos", format.serialize(DurationUnit.NANOSECONDS, 1));
        assertEquals("1 millis", format.serialize(DurationUnit.MILLISECONDS, 1));
        assertEquals("1 sec", format.serialize(DurationUnit.SECONDS, 1));
        assertEquals("1 min", format.serialize(DurationUnit.MINUTES, 1));
        assertEquals("1 hours", format.serialize(DurationUnit.HOURS, 1));
        assertEquals("1 days", format.serialize(DurationUnit.DAYS, 1));
    }

    @Test
    void deserialize() throws InvalidFormatException {
        assertEquals(Duration.ofNanos(1), format.deserialize("nanos", 1));
        assertEquals(Duration.ofMillis(1), format.deserialize("millis", 1));
        assertEquals(Duration.ofSeconds(1), format.deserialize("sec", 1));
        assertEquals(Duration.ofMinutes(1), format.deserialize("min", 1));
        assertEquals(Duration.ofHours(1), format.deserialize("hours", 1));
        assertEquals(Duration.ofDays(1), format.deserialize("days", 1));
    }
}