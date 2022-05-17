package com.sde.passwordmanager.Models;

import javafx.scene.control.ListView;

public class User {

    private static User self = new User();
    public static User get() { return self; }

    private int id;
    private int indexlist;
    private String username;
    private String password;
    private String pin;
    private ListView<Password> UserPasswords = new ListView<Password>();

    public ListView<Password> getUserPasswords() {
        return UserPasswords;
    }

    public Password getSinglePassword() throws NullPointerException {
        return getSinglePassword();
    }

    public Password getSinglePassword(int index) throws NullPointerException{
        return (Password) UserPasswords.getItems().get(index);
    }

    public void setUserPasswords(ListView<Password> userPasswords) {
        UserPasswords = userPasswords;
    }

    public int getIndexlist() {
        return indexlist;
    }

    public void setIndexlist(int indexlist) {
        this.indexlist = indexlist;
    }

    public User() {
    }

    public User(int id, String username, String password, String pin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
