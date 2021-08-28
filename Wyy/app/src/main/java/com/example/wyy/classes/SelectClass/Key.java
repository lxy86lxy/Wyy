package com.example.wyy.classes.SelectClass;

import java.io.Serializable;

public class Key implements Serializable {
    private String name;
    public Key(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
