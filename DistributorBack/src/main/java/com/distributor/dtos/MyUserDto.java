package com.distributor.dtos;

import com.distributor.models.MyRoleJsonHashSet;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

public class MyUserDto implements Serializable {

    private Long id;
    private String login;
    private String email;
    private MyRoleJsonHashSet myRoleJsonHashSet;

    public MyUserDto() {
    }

    public MyUserDto(Long id, String login, String email, MyRoleJsonHashSet myRoleJsonHashSet) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.myRoleJsonHashSet = myRoleJsonHashSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MyRoleJsonHashSet getMyRoleJsonHashSet() {
        return myRoleJsonHashSet;
    }

    public void setMyRoleJsonHashSet(MyRoleJsonHashSet myRoleJsonHashSet) {
        this.myRoleJsonHashSet = myRoleJsonHashSet;
    }
}
