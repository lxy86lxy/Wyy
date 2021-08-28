package com.example.wyy.classes.FindClass;

public class FindSong {
    private String coverImgUrl;
    private String name;
    private String id;
   public FindSong(String coverImgUrl,String name,String id){
       this.coverImgUrl=coverImgUrl;
       this.name=name;
       this.id=id;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
