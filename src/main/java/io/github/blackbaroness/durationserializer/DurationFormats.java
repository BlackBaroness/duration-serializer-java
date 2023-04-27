package io.github.blackbaroness.durationserializer;

import io.github.blackbaroness.durationserializer.format.DurationFormat;
import io.github.blackbaroness.durationserializer.format.impl.*;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class DurationFormats {

    private final ShortEnglishDurationFormat shortEnglish = new ShortEnglishDurationFormat();
    private final MediumLengthEnglishDurationFormat mediumLengthEnglish = new MediumLengthEnglishDurationFormat();
    private final FullWordEnglishDurationFormat fullWordEnglish = new FullWordEnglishDurationFormat();

    private final ShortRussianDurationFormat shortRussianDurationFormat = new ShortRussianDurationFormat();
    private final MediumLenghtRussianDurationFormat mediumLengthRussianDurationFormat = new MediumLenghtRussianDurationFormat();

    @Contract(pure = true)
    public @NotNull DurationFormat shortEnglish() {
        return shortEnglish;
    }

    @Contract(pure = true)
    public @NotNull DurationFormat mediumLengthEnglish() {
        return mediumLengthEnglish;
    }

    @Contract(pure = true)
    public @NotNull DurationFormat fullWordEnglish() {
        return fullWordEnglish;
    }

    @Contract(pure = true)
    public @NotNull ShortRussianDurationFormat shortRussian() {
        return shortRussianDurationFormat;
    }

    @Contract(pure = true)
    public @NotNull DurationFormat mediumLengthRussian() {
        return mediumLengthRussianDurationFormat;
    }

    @Contract(value = "-> new", pure = true)
    public @NotNull DurationFormat @NotNull [] allBundled() {
        return new DurationFormat[]{shortEnglish, mediumLengthEnglish, fullWordEnglish};
    }
}
