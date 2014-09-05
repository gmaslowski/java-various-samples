package com.gmaslowski.spock.sample

import com.gmaslowski.spock.sample.repo.DummyRepository
import com.gmaslowski.spock.sample.service.DummyService
import spock.lang.Specification

import static com.gmaslowski.spock.sample.entity.DummyObjectMother.ACTIVE_DUMMY_OBJECT
import static com.gmaslowski.spock.sample.entity.DummyObjectMother.NOT_ACTIVE_DUMMY_OBJECT

class GroovyDummyServiceTest extends Specification {

    def dummyRepository = Mock(DummyRepository)

    def dummyService = new DummyService(dummyRepository)

    private int dummyId = 17

    def "shouldDeactivateDummyOnRetrievalOfActiveDummy"() {
        setup:
        dummyRepository.getDummyById(dummyId) >> ACTIVE_DUMMY_OBJECT

        when:
        def dummy = dummyService.dummyLogic(dummyId)

        then:
        !dummy.active
    }


    def "shouldDeactivateDummyOnRetrievalOfNotActiveDummy"() {
        setup:
        dummyRepository.getDummyById(dummyId) >> NOT_ACTIVE_DUMMY_OBJECT

        when:
        def dummy = dummyService.dummyLogic(dummyId)

        then:
        !dummy.active
    }

    def "shouldCallRepositoryTwoTimes"() {
        when:
        dummyService.evenDummierLogic(dummyId)

        then:
        2 * dummyRepository.getDummyById(dummyId)
    }
}