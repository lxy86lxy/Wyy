package com.example.wyy.classes.MvClass;

import java.io.Serializable;
import java.util.List;

//@lombok.Data
public class Mms implements Serializable {

    /**
     * id : 10929390
     * cover : http://p1.music.126.net/2cXJJRroBgy2wULzQ0SQlg==/109951165923968787.jpg
     * name : Wheels on the Bus
     * playCount : 42599
     * briefDesc : null
     * desc : null
     * artistName : 斑马儿歌
     * artistId : 35229524
     * duration : 152000
     * mark : 0
     * subed : false
     * artists : [{"id":35229524,"name":"斑马儿歌","alias":[],"transNames":null}]
     */

    private String id;
    private String cover;
    private String name;
    private int playCount;
    private Object briefDesc;
    private Object desc;
    private String artistName;
    private int artistId;
    private int duration;
    private int mark;
    private boolean subed;
    private List<ArtistsBean> artists;

//    @lombok.Data
    public static class ArtistsBean implements Serializable {
        /**
         * id : 35229524
         * name : 斑马儿歌
         * alias : []
         * transNames : null
         */

        private int id;
        private String name;
        private Object transNames;
        private List<?> alias;
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
