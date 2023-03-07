package com.github.blackbaroness.durationserializer;

import com.github.blackbaroness.durationserializer.format.DurationFormat;
import com.github.blackbaroness.durationserializer.format.DurationUnit;
import com.github.blackbaroness.durationserializer.format.InvalidFormatException;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

@UtilityClass
public class DurationSerializer {

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull String serialize(@NotNull Duration duration, final @NotNull DurationFormat format) {
        StringBuilder resultBuilder = new StringBuilder();

        final long days = duration.toDays();
        if (days > 0) {
            resultBuilder.append(format.serialize(DurationUnit.DAYS, days)).append(" ");
            duration = duration.minusDays(days);
        }

        final long hours = duration.toHours();
        if (hours > 0) {
            resultBuilder.append(format.serialize(DurationUnit.HOURS, hours)).append(" ");
            duration = duration.minusHours(hours);
        }

        final long minutes = duration.toMinutes();
        if (minutes > 0) {
            resultBuilder.append(format.serialize(DurationUnit.MINUTES, minutes)).append(" ");
            duration = duration.minusMinutes(minutes);
        }

        final long seconds = duration.getSeconds();
        if (seconds > 0) {
            resultBuilder.append(format.serialize(DurationUnit.SECONDS, seconds)).append(" ");
            duration = duration.minusSeconds(seconds);
        }

        final long milliseconds = duration.toMillis();
        if (milliseconds > 0) {
            resultBuilder.append(format.serialize(DurationUnit.MILLISECONDS, milliseconds)).append(" ");
            duration = duration.minusMillis(milliseconds);
        }

        final long nanoseconds = duration.toNanos();
        if (nanoseconds > 0) {
            resultBuilder.append(format.serialize(DurationUnit.NANOSECONDS, nanoseconds));
        }

        return resultBuilder.toString().trim();
    }

    @Contract(value = "_ -> new", pure = true)
    public @NotNull Duration deserialize(final @NotNull String durationString) throws InvalidFormatException {
        return deserialize(durationString, DurationFormats.allBundled());
    }

    @Contract(value = "_, _ -> new", pure = true)
    public @NotNull Duration deserialize(final @NotNull String durationString, final @NotNull DurationFormat @NotNull ... formats) throws InvalidFormatException {
        if (durationString.isEmpty()) {
            return Duration.ZERO;
        }

        final String[] stringParts = durationString.split(" ");
        if (stringParts.length % 2 != 0) {
            throw new InvalidFormatException(durationString);
        }

        Duration result = Duration.ZERO;

        for (int i = 0; i < stringParts.length; i += 2) {
            result = result.plus(parseDuration(stringParts[i], stringParts[i + 1], formats));
        }

        return result;
    }

    private Duration parseDuration(String amountString, String unitString, DurationFormat... formats) throws InvalidFormatException {
        final long amount = parseAmount(amountString);

        for (DurationFormat format : formats) {
            try {
                return format.deserialize(unitString, amount);
            } catch (InvalidFormatException ignored) {
            }
        }

        throw new InvalidFormatException("Format was not accepted by any of the formats: "
                + amountString + " " + unitString
        );
    }

    private long parseAmount(String amountString) throws InvalidFormatException {
        try {
            return Long.parseLong(amountString);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("Invalid amount: " + amountString);
        }
    }
}


