package com.gmaslowski.spock.sample;

import static org.fest.assertions.Assertions.assertThat;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedTest {


    @Test
    @Parameters({"1, 7, 8", "5, 18, 23"})
    public void shouldAddTwoNumbers(int el1, int el2, int expectedSum) {
        // given
        int sum = 0;

        // when
        sum = el1 + el2;

        // then
        assertThat(expectedSum).isEqualTo(sum);
    }
}
