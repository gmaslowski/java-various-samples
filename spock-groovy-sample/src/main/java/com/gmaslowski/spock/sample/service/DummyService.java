package com.gmaslowski.spock.sample.service;

import com.gmaslowski.spock.sample.entity.Dummy;
import com.gmaslowski.spock.sample.repo.DummyRepository;

public class DummyService {

    private DummyRepository dummyRepository;

    public DummyService(DummyRepository dummyRepository) {
        this.dummyRepository = dummyRepository;
    }

    public Dummy dummyLogic(int dummyId) {
        Dummy dummy = dummyRepository.getDummyById(dummyId);
        dummy.deactivate();

        return dummy;
    }

    public Dummy evenDummierLogic(int dummyId) {
        dummyRepository.getDummyById(dummyId);
        return dummyRepository.getDummyById(dummyId);
    }

}
