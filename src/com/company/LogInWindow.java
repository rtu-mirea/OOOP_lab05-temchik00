package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInWindow extends JFrame{
    private JTextField loginField;
    private JPasswordField passwordField;
    private JPanel mainPanel;
    private JButton signInButton;
    private JButton enterButton;

    public LogInWindow(){
        super("Вход");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(250, 220);
        this.setLocation(200, 200);
        this.setVisible(true);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationWindow register = new RegistrationWindow(getLocation());
            }
        });
    }
}
