package com.gmaslowski.spock.sample.entity;

import static com.gmaslowski.spock.sample.entity.Dummy.DummyBuilder.aDummy;

public class DummyObjectMother {

    private DummyObjectMother() {
    }

    public static final Dummy ACTIVE_DUMMY_OBJECT = aDummy()
            .id(1)
            .name("dummy")
            .active(true)
            .build();

    public static final Dummy NOT_ACTIVE_DUMMY_OBJECT = aDummy()
            .id(2)
            .name("dummy")
            .active(false)
            .build();

}
