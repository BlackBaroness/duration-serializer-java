package com.github.blackbaroness.durationserializer;

import com.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.github.blackbaroness.durationserializer.DurationFormats.shortEnglish;
import static com.github.blackbaroness.durationserializer.DurationSerializer.deserialize;
import static com.github.blackbaroness.durationserializer.DurationSerializer.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DurationSerializerTest {

    @Test
    void test_serialize() {
        assertEquals("", serialize(Duration.ZERO, shortEnglish()));
        assertEquals("15 s", serialize(Duration.ofSeconds(15), shortEnglish()));
        assertEquals("20 min 15 s", serialize(Duration.ofSeconds(15).plusMinutes(20), shortEnglish()));
        assertEquals(
                "1 d 14 h 20 min 15 s 5 ms 1 ns",
                serialize(Duration.ofDays(1).plusHours(14).plusMinutes(20).plusSeconds(15).plusMillis(5).plusNanos(1), shortEnglish())
        );
    }

    @Test
    void test_deserialize() throws InvalidFormatException {
        assertEquals(Duration.ZERO, deserialize("", shortEnglish()));
        assertEquals(Duration.ofDays(1), deserialize("1 d", shortEnglish()));

    }
}
