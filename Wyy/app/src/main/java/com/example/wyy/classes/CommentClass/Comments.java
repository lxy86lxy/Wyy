package com.example.wyy.classes.CommentClass;

import java.io.Serializable;

public class Comments implements Serializable {
    private String nickname;
    private String avatarUrl;
    private String content;
public Comments(String nickname,String avatarUrl,String content){
    this.nickname=nickname;
    this.avatarUrl=avatarUrl;
    this.content=content;
}
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
