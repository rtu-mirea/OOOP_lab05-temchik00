package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class userWindow extends JFrame{
    private JButton exitButton;
    private JPanel mainPanel;
    private JButton changeButton;
    private JComboBox fromBox;
    private JComboBox toBox;
    private JButton findFromButton;
    private JButton findButton;

    public userWindow(UserInfo users, MyMap map, Point pos, int index){
        super("Пользователь - " + users.getClient(index).name);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocation(pos);
        String[] content = map.getAllNodes();
        for(String node : content){
            fromBox.addItem(node);
            toBox.addItem(node);
        }
        this.setVisible(true);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeWindow window = new ChangeWindow(users, map, index, getLocation());
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInWindow logInWindow = new LogInWindow(users, map);
                dispose();
            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((users.getClient(index).getPlace() + "").equals(toBox.getSelectedItem() + "")){
                    JOptionPane.showMessageDialog(mainPanel, "Вы уже находитесь в заданной точке");
                    return;
                }
                ArrayList<String> path = map.generateShortWay(users.getClient(index).getPlace() + "", toBox.getSelectedItem() + "");
                if(path == null || path.size() == 0)
                    JOptionPane.showMessageDialog(mainPanel, "Пути не существует");
                else {
                    String ans = "Кратчайший путь: ";
                    for(int i = 0; i < path.size() - 1; ++i)
                        ans += path.get(i) + "->";
                    ans += path.get(path.size() - 1);
                    JOptionPane.showMessageDialog(mainPanel, ans);
                }
            }
        });
        findFromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((fromBox.getSelectedItem() + "").equals(toBox.getSelectedItem() + "")){
                    JOptionPane.showMessageDialog(mainPanel, "Вы уже находитесь в заданной точке");
                    return;
                }
                ArrayList<String> path = map.generateShortWay(fromBox.getSelectedItem() + "", toBox.getSelectedItem() + "");
                if(path == null || path.size() == 0)
                    JOptionPane.showMessageDialog(mainPanel, "Пути не существует");
                else {
                    String ans = "Кратчайший путь: ";
                    for(int i = 0; i < path.size() - 1; ++i)
                        ans += path.get(i) + "->";
                    ans += path.get(path.size() - 1);
                    JOptionPane.showMessageDialog(mainPanel, ans);
                }
            }
        });
    }
}
