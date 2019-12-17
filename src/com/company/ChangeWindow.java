package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeWindow extends JFrame{
    private JButton cancelButton;
    private JPanel mainPanel;
    private JPasswordField oldPassField;
    private JTextField newNameField;
    private JButton nameButton;
    private JPasswordField newPassField;
    private JButton passButton;
    private JTextField newLoginField;
    private JButton loginButton;
    private JComboBox comboBox;
    private JButton placeButton;
    private JLabel labelPlace;
    private JLabel labelLogin;

    public ChangeWindow(UserInfo users, MyMap map, int currUser, Point pos){
        super("Изменение данных");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocation(pos);
        if (currUser == -2){
            labelPlace.setVisible(false);
            comboBox.setVisible(false);
            placeButton.setVisible(false);
        }else {
            loginButton.setVisible(false);
            labelLogin.setVisible(false);
            newLoginField.setVisible(false);String[] content = map.getAllNodes();
            for(String node : content){
                comboBox.addItem(node);
            }
        }
        this.setVisible(true);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        nameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currUser == -2){
                    String pass = new String(oldPassField.getPassword());
                    if(users.getAdmin().getPassword().equals(pass)){
                        if(newNameField.getText().length() < 2){
                            JOptionPane.showMessageDialog(mainPanel, "Слишком короткое имя");
                        }
                        else{
                            users.getAdmin().setPassword(pass);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                    }
                }else{
                    String pass = new String(oldPassField.getPassword());
                    if(users.getClient(currUser).getPassword().equals(pass)){
                        if(newNameField.getText().length() < 2){
                            JOptionPane.showMessageDialog(mainPanel, "Слишком короткое имя");
                        }
                        else{
                            users.getClient(currUser).setPassword(pass);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                    }
                }
            }
        });

        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currUser == -2){
                    String pass = new String(oldPassField.getPassword());
                    String newPass = new String(newPassField.getPassword());
                    if(users.getAdmin().getPassword().equals(pass)){
                        if(newPass.length() < 8){
                            JOptionPane.showMessageDialog(mainPanel, "Пароль слишком короткий");
                        }
                        else{
                            users.getAdmin().setPassword(newPass);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                    }
                }else{
                    String pass = new String(oldPassField.getPassword());
                    String newPass = new String(newPassField.getPassword());
                    if(users.getClient(currUser).getPassword().equals(pass)){
                        if(newPass.length() < 8){
                            JOptionPane.showMessageDialog(mainPanel, "Пароль слишком короткий");
                        }
                        else{
                            users.getClient(currUser).setPassword(newPass);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                    }
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(oldPassField.getPassword());
                if(users.getAdmin().getPassword().equals(pass)){
                    if(newLoginField.getText().length() < 3){
                        JOptionPane.showMessageDialog(mainPanel, "Логин слишком короткий");
                    }
                    else{
                        if(users.hasUser(newLoginField.getText())){
                            JOptionPane.showMessageDialog(mainPanel, "Логин занят");
                        }
                        else {
                            users.getAdmin().setLogin(newLoginField.getText());
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                }
            }
        });

        placeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(oldPassField.getPassword());
                if(users.getClient(currUser).getPassword().equals(pass)){
                        users.getClient(currUser).setPlace(comboBox.getSelectedItem() + "");
                }
                else{
                    JOptionPane.showMessageDialog(mainPanel, "Пароли не совпадают");
                }
            }
        });
    }
}
