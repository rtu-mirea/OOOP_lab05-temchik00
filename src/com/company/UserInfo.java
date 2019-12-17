package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.logging.FileHandler;

public class UserInfo {
    private Admin admin;
    private LinkedList<Client> clients;

    UserInfo(){
        admin = new Admin();
        clients = new LinkedList<Client>();
        try {
            File file = new File("savedInfo//users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String info = reader.readLine();
            if(info != null){
                String[] parts = info.split(" ");
                admin.setName(parts[0]);
                admin.setLogin(parts[1]);
                admin.setPassword(parts[2]);
            }
            while ((info = reader.readLine()) != null){
                clients.add(new Client(info));
            }
        }catch (Exception e){
            System.out.println("Could not load from file");
        }
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

    public void saveToFile() throws Exception {
        File file = new File("savedInfo//users.txt");
        file.createNewFile();
        String data = admin.name + " " + admin.login + " " + admin.password + "\n";
        FileWriter writer = new FileWriter(file, false);
        writer.write(data);
        for(Client client : clients){
            writer.write(client.toString());
        }
        writer.close();
    }
}
