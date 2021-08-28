package com.example.wyy.classes.lyric;

import java.io.Serializable;

public class Word implements Serializable {
    private String lyric;

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}
