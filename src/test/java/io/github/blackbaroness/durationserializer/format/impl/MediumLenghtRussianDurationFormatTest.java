package io.github.blackbaroness.durationserializer.format.impl;

import io.github.blackbaroness.durationserializer.DurationFormats;
import io.github.blackbaroness.durationserializer.format.DurationFormat;
import io.github.blackbaroness.durationserializer.format.DurationUnit;
import io.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediumLenghtRussianDurationFormatTest {

    private final DurationFormat format = DurationFormats.mediumLengthRussian();

    @Test
    void serialize() {
        assertEquals("1 нсек", format.serialize(DurationUnit.NANOSECONDS, 1));
        assertEquals("1 мсек", format.serialize(DurationUnit.MILLISECONDS, 1));
        assertEquals("1 сек", format.serialize(DurationUnit.SECONDS, 1));
        assertEquals("1 мин", format.serialize(DurationUnit.MINUTES, 1));
        assertEquals("1 ч", format.serialize(DurationUnit.HOURS, 1));
        assertEquals("1 дн", format.serialize(DurationUnit.DAYS, 1));
    }

    @Test
    void deserialize() throws InvalidFormatException {
        assertEquals(Duration.ofNanos(1), format.deserialize("нсек", 1));
        assertEquals(Duration.ofMillis(1), format.deserialize("мсек", 1));
        assertEquals(Duration.ofSeconds(1), format.deserialize("сек", 1));
        assertEquals(Duration.ofMinutes(1), format.deserialize("мин", 1));
        assertEquals(Duration.ofHours(1), format.deserialize("ч", 1));
        assertEquals(Duration.ofDays(1), format.deserialize("дн", 1));
    }
}
