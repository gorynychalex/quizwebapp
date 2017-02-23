package ru.popovich.server.model;

public class Admin extends User{

    public Admin(int id, String firstname, String lastname, String password, String userCategory) {
        super(id, firstname, lastname, password, userCategory);
    }

}
