package com.company;

import java.util.LinkedList;

public class UserInfo {
    private Admin admin;
    private LinkedList<Client> clients;
    UserInfo(){
        admin = new Admin();
        clients = new LinkedList<Client>();
    }

    UserInfo(String path){
        // TODO: loadFromFile
        admin = new Admin();
        clients = new LinkedList<Client>();
    }

    public Admin getAdmin() {
        return admin;
    }

    public Client getClient(int index){
        return clients.get(index);
    }

    public int logIn(String login, String password){
        if(admin.enter(login, password))
            return -2;
        for(int i = 0; i < clients.size(); ++i)
            if(clients.get(i).enter(login, password))
                return i;
        return -1;
    }

    public boolean hasUser(String login){
        if(admin.login.equals(login))
            return true;
        for(int i = 0; i < clients.size(); ++i)
            if(clients.get(i).login.equals(login))
                return true;
        return false;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void saveToFile(String path){
        // TODO: make saving
    }
}
