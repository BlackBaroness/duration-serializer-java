package com.github.blackbaroness.durationserializer;

import com.github.blackbaroness.durationserializer.format.DurationFormat;
import com.github.blackbaroness.durationserializer.format.impl.FullWordEnglishDurationFormat;
import com.github.blackbaroness.durationserializer.format.impl.MediumLengthEnglishDurationFormat;
import com.github.blackbaroness.durationserializer.format.impl.ShortEnglishDurationFormat;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class DurationFormats {

    private final ShortEnglishDurationFormat shortEnglish = new ShortEnglishDurationFormat();
    private final MediumLengthEnglishDurationFormat mediumLengthEnglish = new MediumLengthEnglishDurationFormat();
    private final FullWordEnglishDurationFormat fullWordEnglish = new FullWordEnglishDurationFormat();

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

    @Contract(value = "-> new", pure = true)
    public @NotNull DurationFormat @NotNull [] allBundled() {
        return new DurationFormat[]{shortEnglish, mediumLengthEnglish, fullWordEnglish};
    }
}
