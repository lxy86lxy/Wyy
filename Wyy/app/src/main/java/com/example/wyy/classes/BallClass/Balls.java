package com.example.wyy.classes.BallClass;

import java.io.Serializable;
//
//@lombok.Data
public class Balls implements Serializable {

    /**
     * id : -1
     * name : 每日推荐
     * iconUrl : http://p1.music.126.net/4DpSgAVpJny4Ewf-Xw_WQQ==/109951163986641971.jpg
     * url : orpheus://songrcmd
     * skinSupport : true
     * homepageMode : RCMD_MODE
     */

    private int id;
    private String name;
    private String iconUrl;
    private String url;
    private boolean skinSupport;
    private String homepageMode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSkinSupport() {
        return skinSupport;
    }

    public void setSkinSupport(boolean skinSupport) {
        this.skinSupport = skinSupport;
    }

    public String getHomepageMode() {
        return homepageMode;
    }

    public void setHomepageMode(String homepageMode) {
        this.homepageMode = homepageMode;
    }
}
