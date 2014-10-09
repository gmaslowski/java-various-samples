package com.gmaslowski.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class SwingFrame extends JFrame {

    public void createAndShowUI() {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());

        JButton clickMeButton = new JButton("Click Me!");
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(SwingFrame.this, "Hello Clicker!");
            }
        });

        getRootPane().setDefaultButton(clickMeButton);


        this.add(clickMeButton);

        this.setVisible(true);
    }


}
