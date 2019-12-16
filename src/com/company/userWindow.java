package com.company;

import javax.swing.*;
import java.awt.*;

public class userWindow extends JFrame{
    private JButton exitButton;
    private JPanel mainPanel;
    public userWindow(User user, Point pos){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(pos);
        this.setVisible(true);
    }
}
