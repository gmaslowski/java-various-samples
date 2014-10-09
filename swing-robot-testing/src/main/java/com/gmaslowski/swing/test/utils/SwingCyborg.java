package com.gmaslowski.swing.test.utils;

import java.awt.AWTException;
import java.awt.Robot;

import static java.awt.event.KeyEvent.VK_ENTER;

public final class SwingCyborg {

    private Robot robot;

    private SwingCyborg() {
        try {
            robot = new Robot();
        } catch (AWTException awte) {
            throw new RuntimeException(awte);
        }

        robot.setAutoWaitForIdle(true);
    }

    public static SwingCyborg swingCyborg() {
        return new SwingCyborg();
    }

    public void enterKey() {
        typeKey(VK_ENTER);
    }

    private void typeKey(final int key) {
        robot.keyPress(key);
        pause();
        robot.keyRelease(key);

    }

    private void pause() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException swallow) {
        }
    }

}
