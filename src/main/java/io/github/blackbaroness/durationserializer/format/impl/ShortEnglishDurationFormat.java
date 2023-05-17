package io.github.blackbaroness.durationserializer.format.impl;

public class ShortEnglishDurationFormat extends StaticDurationFormat {

    public ShortEnglishDurationFormat() {
        super("ns",
            "ms",
            "s",
            "min",
            "h",
            "d");
    }
}
