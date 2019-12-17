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
    private JComboBox comboBox;

    public RegistrationWindow(UserInfo userInfo, MyMap map, Point pos){
        super("Регистрация");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(260, 380);
        this.setLocation(pos);
        String[] content = map.getAllNodes();
        for(String node : content){
            comboBox.addItem(node);
        }
        this.setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(passwordField.getPassword());
                if(!pass.equals(new String(passwordField2.getPassword()))){
                    JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                }
                else if(pass.length() < 6){
                    JOptionPane.showMessageDialog(mainPanel, "Пароль слишком короткий");
                }
                else{
                    if(!userInfo.hasUser(loginField.getText())) {
                        userInfo.addClient(new Client(nameField.getText(), loginField.getText(), pass, comboBox.getSelectedItem() + ""));
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(mainPanel, "Данный логин уже занят");
                    }
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
