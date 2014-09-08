package com.gmaslowski.spock.sample

import spock.lang.Specification

class GroovyListsTest extends Specification {

    def "shouldAssertList"() {
        when:
        def names = ["John", "Jane", "Jim", "Juan", "Juan"]

        then:
        names.contains("John")
        names.collect().unique() == ["John", "Jane", "Jim", "Juan"]
        names == ["John", "Jane", "Jim", "Juan", "Juan"]
    }
}