package com.gmaslowski.spock.sample;

import static com.gmaslowski.spock.sample.entity.DummyObjectMother.ACTIVE_DUMMY_OBJECT;
import static com.gmaslowski.spock.sample.entity.DummyObjectMother.NOT_ACTIVE_DUMMY_OBJECT;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import com.gmaslowski.spock.sample.entity.Dummy;
import com.gmaslowski.spock.sample.repo.DummyRepository;
import com.gmaslowski.spock.sample.service.DummyService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DummyServiceTest {

    private int dummyId = 17;

    @Before
    public void injectMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private DummyRepository dummyRepository;

    @InjectMocks
    private DummyService dummyService;

    @Test
    public void shouldDeactivateDummyOnRetrievalOfActiveDummy() {
        // given
        given(dummyRepository.getDummyById(anyInt())).willReturn(ACTIVE_DUMMY_OBJECT);

        // when
        Dummy dummy = dummyService.dummyLogic(dummyId);

        // then
        assertThat(dummy.isActive()).isFalse();
    }

    @Test
    public void shouldDeactivateDummyOnRetrievalOfNotActiveDummy() {
        // given
        given(dummyRepository.getDummyById(anyInt())).willReturn(NOT_ACTIVE_DUMMY_OBJECT);

        // when
        Dummy dummy = dummyService.dummyLogic(dummyId);

        // then
        assertThat(dummy.isActive()).isFalse();
    }

    @Test
    public void shouldCallRepositoryTwoTimes() {
        // when
        dummyService.evenDummierLogic(dummyId);

        // then
        verify(dummyRepository, times(2)).getDummyById(dummyId);
    }
}
