package io.github.blackbaroness.durationserializer.format.impl;

public class MediumLengthEnglishDurationFormat extends StaticDurationFormat {

    public MediumLengthEnglishDurationFormat() {
        super("nanos",
            "millis",
            "sec",
            "min",
            "hours",
            "days");
    }
}
