package com.example.wyy.classes.MvClass;

public class Mm {
    private String id;
    private String cover;
    private String name;

    public Mm(String id,String cover,String name){
        this.id=id;
        this.cover=cover;
        this.name=name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
