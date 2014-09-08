package com.gmaslowski.spock.sample;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import java.util.List;
import org.junit.Test;

public class ListsTest {

    @Test
    public void shouldAssertList() {
        // given
        List<String> names = newArrayList("John", "Jane", "Jim", "Juan", "Juan");

        // then
        assertThat(names).contains("John");
        assertThat(names).containsOnly("John", "Jane", "Jim", "Juan");
        assertThat(names).containsExactly("John", "Jane", "Jim", "Juan", "Juan");
    }
}
