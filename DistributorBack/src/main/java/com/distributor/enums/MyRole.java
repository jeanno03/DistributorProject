package com.distributor.enums;

import java.io.Serializable;

public enum MyRole implements Serializable {

    VISITOR("visitor"),
    USER("user"),
    ADMINISTRATOR("administrator");

    private String type;

    private MyRole(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
