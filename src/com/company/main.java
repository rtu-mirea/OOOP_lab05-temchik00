package com.company;

import javax.swing.*;

public class main {
    public static void main(String[] args){
        UserInfo userInfo = new UserInfo();
        MyMap map = new MyMap();
        map.load();
        JFrame t = new LogInWindow(userInfo, map);
    }
}
