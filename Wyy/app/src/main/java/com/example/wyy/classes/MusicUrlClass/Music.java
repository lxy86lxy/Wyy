package com.example.wyy.classes.MusicUrlClass;

import java.io.Serializable;

//@lombok.Data
public class Music implements Serializable {

    /**
     * id : 1867936253
     * url : http://m801.music.126.net/20210821130206/b6ac5089d9d6f88bf030c96753a563c0/jdymusic/obj/wo3DlMOGwrbDjj7DisKw/10238788214/250c/6df7/1ab8/e9f5b962dafb39ce2f03d2222c80ba14.mp3
     * br : 128000
     * size : 4218669
     * md5 : e9f5b962dafb39ce2f03d2222c80ba14
     * code : 200
     * expi : 1200
     * type : mp3
     * gain : 0.0
     * fee : 8
     * uf : null
     * payed : 0
     * flag : 68
     * canExtend : false
     * freeTrialInfo : null
     * level : standard
     * encodeType : mp3
     * freeTrialPrivilege : {"resConsumable":false,"userConsumable":false}
     * freeTimeTrialPrivilege : {"resConsumable":false,"userConsumable":false,"type":0,"remainTime":0}
     * urlSource : 0
     */

    private int id;
    private String url;
    private int br;
    private int size;
    private String md5;
    private int code;
    private int expi;
    private String type;
    private double gain;
    private int fee;
    private Object uf;
    private int payed;
    private int flag;
    private boolean canExtend;
    private Object freeTrialInfo;
    private String level;
    private String encodeType;
    private FreeTrialPrivilegeBean freeTrialPrivilege;
    private FreeTimeTrialPrivilegeBean freeTimeTrialPrivilege;
    private int urlSource;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //    @lombok.Data
    public static class FreeTrialPrivilegeBean implements Serializable {
        /**
         * resConsumable : false
         * userConsumable : false
         */

        private boolean resConsumable;
        private boolean userConsumable;
    }

   /* @lombok.Data*/
    public static class FreeTimeTrialPrivilegeBean implements Serializable {
        /**
         * resConsumable : false
         * userConsumable : false
         * type : 0
         * remainTime : 0
         */

        private boolean resConsumable;
        private boolean userConsumable;
        private int type;
        private int remainTime;
    }
}
