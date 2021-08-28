package com.example.wyy.classes.BallClass;

public class Ball {
    private String name;
    private String iconUrl;

    public Ball(String name,String iconUrl){
        this.name=name;
        this.iconUrl=iconUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
