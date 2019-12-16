package com.company;

import javax.swing.*;
import java.awt.*;
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
    public RegistrationWindow(Point pos){
        super("Регистрация");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(260, 320);
        this.setLocation(pos);
        this.setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(passwordField.getPassword());
                if(!pass.equals(new String(passwordField2.getPassword()))){
                    JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
