package com.gmaslowski.swing;

import org.junit.Test;

import static com.gmaslowski.swing.test.utils.SwingCyborg.swingCyborg;
import static java.lang.Thread.sleep;

public class SwingApplicationTest {

    @Test
    public void shouldRunAndClickOnSwingApplicationButton() throws InterruptedException {
        new SwingFrame().createAndShowUI();
        new SwingFrameWrapper(swingCyborg()).clickOk();
    }
}