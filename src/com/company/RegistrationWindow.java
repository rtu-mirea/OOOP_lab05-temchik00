package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow extends JFrame {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JButton OKButton;
    private JButton cancelButton;
    public RegistrationWindow(){
        super("Регистрация");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(260, 320);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
