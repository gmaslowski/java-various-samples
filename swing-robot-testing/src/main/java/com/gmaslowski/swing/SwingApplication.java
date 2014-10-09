package com.gmaslowski.swing;

import static javax.swing.SwingUtilities.invokeLater;

public class SwingApplication {

    public static void main(String[] args) {

        invokeLater(new Runnable() {

            @Override
            public void run() {
                new SwingFrame().createAndShowUI();
            }
        });
    }

}
