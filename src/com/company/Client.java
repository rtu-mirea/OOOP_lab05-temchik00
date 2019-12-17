package com.company;

public class Client extends User{
    private String place;

    public Client(String name, String login, String password, String place) {
        super(name, login, password);
        this.place = place;
    }

    public Client(String info){
        super("", "", "");
        String[] parts = info.split(" ");
        name = parts[0];
        login = parts[1];
        password = parts[2];
        place = parts[3];
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String toString(){
        return name + " " + login + " " + password + " " + place + "\n";
    }

    public void copy(Client other){
        this.name = other.name;
        this.login = other.login;
        this.password = other.password;
        this.place = other.place;
    }
}
