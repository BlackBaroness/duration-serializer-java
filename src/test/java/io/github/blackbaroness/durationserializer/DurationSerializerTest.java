package io.github.blackbaroness.durationserializer;

import io.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static io.github.blackbaroness.durationserializer.DurationSerializer.deserialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DurationSerializerTest {

    @Test
    void test_serialize() {
        Assertions.assertEquals("", DurationSerializer.serialize(Duration.ZERO, DurationFormats.shortEnglish()));
        Assertions.assertEquals("15 s", DurationSerializer.serialize(Duration.ofSeconds(15), DurationFormats.shortEnglish()));
        Assertions.assertEquals("20 min 15 s", DurationSerializer.serialize(Duration.ofSeconds(15).plusMinutes(20), DurationFormats.shortEnglish()));
        Assertions.assertEquals(
                "1 d 14 h 20 min 15 s 5 ms 1 ns",
                DurationSerializer.serialize(Duration.ofDays(1).plusHours(14).plusMinutes(20).plusSeconds(15).plusMillis(5).plusNanos(1), DurationFormats.shortEnglish())
        );
    }

    @Test
    void test_deserialize() throws InvalidFormatException {
        Assertions.assertEquals(Duration.ZERO, DurationSerializer.deserialize("", DurationFormats.shortEnglish()));
        Assertions.assertEquals(Duration.ofDays(1), DurationSerializer.deserialize("1 d", DurationFormats.shortEnglish()));

    }
}
