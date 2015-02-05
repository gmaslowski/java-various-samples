package com.gmaslowski.spock.sample;

import static org.fest.assertions.Assertions.assertThat;
import com.gmaslowski.spock.sample.spring.ApplicationConfig;
import com.gmaslowski.spock.sample.spring.TestedSpringBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SpringIntegrationTest {

    @Autowired
    private TestedSpringBean someBean;

    @Test
    public void test() {
        assertThat(someBean.doSomeWork()).isNotNull();
    }

}
