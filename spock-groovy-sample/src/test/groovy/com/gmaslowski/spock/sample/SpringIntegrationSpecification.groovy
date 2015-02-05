package com.gmaslowski.spock.sample

import com.gmaslowski.spock.sample.spring.ApplicationConfig
import com.gmaslowski.spock.sample.spring.TestedSpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = ApplicationConfig.class)
class SpringIntegrationSpecification extends Specification {

    @Autowired
    TestedSpringBean someBean;

    def "test"() {
        expect:
        someBean.doSomeWork() != null
    }

}