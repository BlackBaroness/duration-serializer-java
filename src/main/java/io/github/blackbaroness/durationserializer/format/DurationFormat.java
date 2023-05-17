package io.github.blackbaroness.durationserializer.format;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.time.Duration;

public interface DurationFormat {

    /**
     * Formats the given duration into a string.
     * <p>
     * For example, it can convert MINUTES and 5 to "5 minutes".
     *
     * @param unit   duration unit
     * @param amount duration amount
     * @return string representation of duration unit with specified amount
     */
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull String serialize(@NotNull DurationUnit unit, @Range(from = 0, to = Long.MAX_VALUE) long amount);

    /**
     * Parses the given string into a duration unit.
     * <p>
     * For example, it can convert "5 minutes" to {@code Duration.ofMinutes(5)}.
     *
     * @param unitInput   input string which should contain only duration unit string representation
     * @param amountInput time amount
     * @return parsed duration
     * @throws InvalidFormatException if input string is not a valid duration unit
     */
    @Contract(value = "_, _ -> new", pure = true)
    @NotNull Duration deserialize(
        @NotNull String unitInput,
        @Range(from = 0, to = Long.MAX_VALUE) long amountInput
    ) throws InvalidFormatException;
}
