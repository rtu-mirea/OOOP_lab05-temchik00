package com.company;

import javax.swing.*;
import java.awt.*;

public class adminWindow extends JFrame{
    private JPanel mainPanel;
    private JButton exitButton;
    public adminWindow(Admin admin, Point pos){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(pos);
        this.setVisible(true);
    }
}
