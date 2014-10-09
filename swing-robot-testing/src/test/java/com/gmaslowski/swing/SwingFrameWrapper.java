package com.gmaslowski.swing;

import com.gmaslowski.swing.test.utils.SwingCyborg;

public class SwingFrameWrapper {

    private SwingCyborg swingCyborg;

    public SwingFrameWrapper(SwingCyborg swingCyborg) {
        this.swingCyborg = swingCyborg;
    }

    public void clickOk() {
        swingCyborg.enterKey();
    }
}
