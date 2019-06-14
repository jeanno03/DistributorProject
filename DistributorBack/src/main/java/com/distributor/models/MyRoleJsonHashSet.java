package com.distributor.models;

import com.distributor.enums.MyRole;
import java.io.Serializable;
import java.util.HashSet;

public class MyRoleJsonHashSet implements Serializable {

    private HashSet<MyRole> myRoles;

    public MyRoleJsonHashSet() {
    }

    public MyRoleJsonHashSet(HashSet<MyRole> myRoles) {
        this.myRoles = myRoles;
    }

    public HashSet<MyRole> getMyRoles() {
        return myRoles;
    }

    public void setMyRoles(HashSet<MyRole> myRoles) {
        this.myRoles = myRoles;
    }
}
