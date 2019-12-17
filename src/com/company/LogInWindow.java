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

    public LogInWindow(UserInfo users, MyMap map){
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
                int index = users.logIn(loginField.getText(), new String(passwordField.getPassword()));
                if(index == -1)
                    JOptionPane.showMessageDialog(mainPanel, "Логин или пароль введены неправильно");
                else if(index == -2){
                    adminWindow admin = new adminWindow(users, map, getLocation());
                    dispose();
                }
                else{
                    userWindow user = new userWindow(users.getClient(index), map, getLocation());
                    dispose();
                }
            }
        });
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationWindow register = new RegistrationWindow(users, map, getLocation());
            }
        });
    }
}
