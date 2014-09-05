package com.gmaslowski.spock.sample;

import spock.lang.Specification;

class GroovyParametrizedTest extends Specification {
    int sum = 0

    def "shouldAddTwoNumbers"() {
        when:
        sum = el1 + el2;

        then:
        sum == expectedSum;

        where:
        el1 | el2 | expectedSum
        1   | 13  | 14
        7   | 25  | 32
        15  | 485 | 500
    }

    def "shouldAddTwoNumbersDifferentDataInput"() {
        expect:
        expectedSum == el1 + el2;

        where:
        el1 << [1, 7, 15]
        el2 << [13, 25, 485]
        expectedSum << [14, 32, 500]
    }
}
