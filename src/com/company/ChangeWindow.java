package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeWindow extends JFrame{
    private JButton cancelButton;
    private JButton OKButton;
    private JPanel mainPanel;
    public ChangeWindow(UserInfo users, int currUser, Point pos){
        super("Изменение данных");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocation(pos);
        this.setSize(420, 320);
        this.setVisible(true);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: update users
                dispose();
            }
        });
    }
}
