package com.example.wyy.classes.TopClass;

public class Top {
    private String name;
    private String id;
    private String coverImgUrl;
    private String description;
    public Top(String name,String coverImgUrl,String id,String description){
        this.coverImgUrl=coverImgUrl;
        this.name=name;
        this.id=id;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
