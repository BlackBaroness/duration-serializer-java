package com.github.blackbaroness.durationserializer.format.impl;

public class FullWordEnglishDurationFormat extends StaticDurationFormat {

    public FullWordEnglishDurationFormat() {
        super("nanoseconds",
                "milliseconds",
                "seconds",
                "minutes",
                "hours",
                "days");
    }
}
