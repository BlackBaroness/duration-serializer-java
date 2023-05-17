package io.github.blackbaroness.durationserializer;

import io.github.blackbaroness.durationserializer.format.DurationFormat;
import io.github.blackbaroness.durationserializer.format.impl.*;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class DurationFormats {

    private final ShortEnglishDurationFormat shortEnglish = new ShortEnglishDurationFormat();
    private final MediumLengthEnglishDurationFormat mediumEnglish = new MediumLengthEnglishDurationFormat();
    private final FullWordEnglishDurationFormat fullEnglish = new FullWordEnglishDurationFormat();

    private final ShortRussianDurationFormat shortRussian = new ShortRussianDurationFormat();
    private final MediumLenghtRussianDurationFormat mediumRussian = new MediumLenghtRussianDurationFormat();

    @Contract(pure = true)
    public @NotNull DurationFormat shortEnglish() {
        return shortEnglish;
    }

    @Contract(pure = true)
    public @NotNull DurationFormat mediumLengthEnglish() {
        return mediumEnglish;
    }

    @Contract(pure = true)
    public @NotNull DurationFormat fullWordEnglish() {
        return fullEnglish;
    }

    @Contract(pure = true)
    public @NotNull ShortRussianDurationFormat shortRussian() {
        return shortRussian;
    }

    @Contract(pure = true)
    public @NotNull DurationFormat mediumLengthRussian() {
        return mediumRussian;
    }

    @Contract(value = "-> new", pure = true)
    public @NotNull DurationFormat @NotNull [] allBundled() {
        return new DurationFormat[]{
            shortEnglish, mediumEnglish, fullEnglish,
            shortRussian, mediumRussian
        };
    }
}
