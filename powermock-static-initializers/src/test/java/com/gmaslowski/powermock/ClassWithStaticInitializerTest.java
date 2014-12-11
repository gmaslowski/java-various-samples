package com.gmaslowski.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNull;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.gmaslowski.powermock.ClassWithStaticInitializer")
public class ClassWithStaticInitializerTest {

    @Test
    public void shouldNotInvokeStaticInitializer() {
        // then
        assertNull(ClassWithStaticInitializer.value);
    }

}
