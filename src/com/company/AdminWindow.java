package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame{
    private JPanel mainPanel;
    private JButton exitButton;
    private JTextField fromField;
    private JTextField toField;
    private JTextField weightField;
    private JButton addPathButton;
    private JButton changeButton;
    private JButton saveButton;

    public AdminWindow(UserInfo users, MyMap map, Point pos){
        super("Панель админа");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(pos);
        this.setSize(420, 320);
        this.setVisible(true);
        addPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fromField.getText() == "" || toField.getText() == ""){
                    JOptionPane.showMessageDialog(mainPanel, "Введены некорректные данные");
                }
                else{
                    try{
                        String w = weightField.getText();
                        int weight = Integer.parseInt(w);
                        map.addPath(fromField.getText(), toField.getText(), weight);
                        JOptionPane.showMessageDialog(mainPanel, "Путь добавлен");
                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(mainPanel, "Введены некорректные данные");
                    }
                }
            }
        });
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeWindow window = new ChangeWindow(users, -2, getLocation());
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInWindow logInWindow = new LogInWindow(users, map);
                dispose();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    map.save();
                    users.saveToFile();
                    JOptionPane.showMessageDialog(mainPanel, "Данные успешно сохранены");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, "Не удалось сохранить данные");
                }
            }
        });
    }
}
