package com.distributor.models;

import java.io.Serializable;

public class Credential implements Serializable {
    private String login;
    private String password;

    public Credential() {
        super();
    }

    public Credential(String login, String password) {
        this();
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credential [login=" + login + ", password=" + password + "]";
    }

}
