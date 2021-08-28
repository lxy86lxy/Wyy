package com.example.wyy.classes.SelectClass;

import java.io.Serializable;

public class Select implements Serializable {
    private String musicId;
    private String picUrl;
    private String author;
    private String name;
    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Select(String name, String author, String url,String musicId){
        this.name=name;
        this.author=author;
        this.picUrl=url;
        this.musicId=musicId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
