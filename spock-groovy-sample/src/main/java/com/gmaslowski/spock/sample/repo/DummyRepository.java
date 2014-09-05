package com.gmaslowski.spock.sample.repo;

import com.gmaslowski.spock.sample.entity.Dummy;

public interface DummyRepository {
    Dummy getDummyById(int i);
}
