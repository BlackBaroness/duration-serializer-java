package io.github.blackbaroness.durationserializer.format.impl;

import io.github.blackbaroness.durationserializer.format.DurationFormat;
import io.github.blackbaroness.durationserializer.format.DurationUnit;
import io.github.blackbaroness.durationserializer.format.InvalidFormatException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import java.time.Duration;

public abstract class StaticDurationFormat implements DurationFormat {

    private final String nanosecondsFormat;
    private final String millisecondsFormat;
    private final String secondsFormat;
    private final String minutesFormat;
    private final String hoursFormat;
    private final String daysFormat;

    public StaticDurationFormat(String nanosecondsFormat, String millisecondsFormat, String secondsFormat, String minutesFormat, String hoursFormat, String daysFormat) {
        this.nanosecondsFormat = nanosecondsFormat;
        this.millisecondsFormat = millisecondsFormat;
        this.secondsFormat = secondsFormat;
        this.minutesFormat = minutesFormat;
        this.hoursFormat = hoursFormat;
        this.daysFormat = daysFormat;
    }

    @Override
    public @NotNull String serialize(@NotNull DurationUnit unit, @Range(from = 0, to = Long.MAX_VALUE) long amount) {
        return amount + " " + getDurationFormat(unit);
    }

    @Override
    public @NotNull Duration deserialize(@NotNull String unitInput, @Range(from = 0, to = Long.MAX_VALUE) long amountInput) throws InvalidFormatException {
        switch (getDurationUnit(unitInput)) {
            case NANOSECONDS:
                return Duration.ofNanos(amountInput);
            case MILLISECONDS:
                return Duration.ofMillis(amountInput);
            case SECONDS:
                return Duration.ofSeconds(amountInput);
            case MINUTES:
                return Duration.ofMinutes(amountInput);
            case HOURS:
                return Duration.ofHours(amountInput);
            case DAYS:
                return Duration.ofDays(amountInput);
            default:
                throw new InvalidFormatException("Unknown duration unit: " + unitInput);
        }
    }

    private String getDurationFormat(DurationUnit unit) {
        switch (unit) {
            case NANOSECONDS:
                return nanosecondsFormat;
            case MILLISECONDS:
                return millisecondsFormat;
            case SECONDS:
                return secondsFormat;
            case MINUTES:
                return minutesFormat;
            case HOURS:
                return hoursFormat;
            case DAYS:
                return daysFormat;
            default:
                throw new IllegalStateException("Unsupported DurationUnit: " + unit);
        }
    }

    private DurationUnit getDurationUnit(String unitInput) throws InvalidFormatException {
        if (unitInput.equalsIgnoreCase(nanosecondsFormat)) {
            return DurationUnit.NANOSECONDS;
        } else if (unitInput.equalsIgnoreCase(millisecondsFormat)) {
            return DurationUnit.MILLISECONDS;
        } else if (unitInput.equalsIgnoreCase(secondsFormat)) {
            return DurationUnit.SECONDS;
        } else if (unitInput.equalsIgnoreCase(minutesFormat)) {
            return DurationUnit.MINUTES;
        } else if (unitInput.equalsIgnoreCase(hoursFormat)) {
            return DurationUnit.HOURS;
        } else if (unitInput.equalsIgnoreCase(daysFormat)) {
            return DurationUnit.DAYS;
        } else {
            throw new InvalidFormatException("Unknown duration unit: " + unitInput);
        }
    }
}
