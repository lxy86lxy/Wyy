package com.example.wyy.classes.SongClass;

import java.io.Serializable;

public class SList implements Serializable {
    private String name;
    private String author;
    private String picUrl;//图片链接
    private String musicId;//音乐id得到音乐url
    private String allPic;//背景
    private String titleImageUrl;//抬头
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleImageUrl() {
        return titleImageUrl;
    }

    public void setTitleImageUrl(String titleImageUrl) {
        this.titleImageUrl = titleImageUrl;
    }

    public String getAllPic() {
        return allPic;
    }

    public void setAllPic(String allPic) {
        this.allPic = allPic;
    }

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

    public SList(String name, String author, String url,String musicId,String description,String allPic,String titleImageUrl){
        this.allPic=allPic;
        this.titleImageUrl=titleImageUrl;
        this.description=description;
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
