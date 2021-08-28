package com.example.wyy.classes.SelectClass;

import java.io.Serializable;
import java.util.List;

//@lombok.Data
public class Selects implements Serializable {

    /**
     * name : 海阔天空
     * id : 346089
     * pst : 0
     * t : 0
     * ar : [{"id":11127,"name":"Beyond","tns":[],"alias":["超越"],"alia":["超越"]}]
     * alia : []
     * pop : 100
     * st : 0
     * rt : 600902000004240302
     * fee : 8
     * v : 40
     * crbt : null
     * cf :
     * al : {"id":34110,"name":"Beyond 25th Anniversary","picUrl":"http://p4.music.126.net/zZtUDuWk6qIe3ezMt4UMjg==/109951165796417308.jpg","tns":[],"pic_str":"109951165796417308","pic":109951165796417310}
     * dt : 322000
     * h : {"br":320000,"fid":0,"size":12905577,"vd":-25300}
     * m : {"br":192000,"fid":0,"size":7743363,"vd":-22800}
     * l : {"br":128000,"fid":0,"size":5162256,"vd":-21300}
     * a : null
     * cd : 03
     * no : 6
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * djId : 0
     * copyright : 1
     * s_id : 0
     * mark : 0
     * originCoverType : 0
     * originSongSimpleData : null
     * resourceState : true
     * version : 40
     * single : 0
     * noCopyrightRcmd : null
     * rtype : 0
     * rurl : null
     * mst : 9
     * cp : 7002
     * mv : 376199
     * publishTime : 1205164800000
     * tns : ["Boundless Oceans, Vast Skies"]
     * privilege : {"id":346089,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000,"rscl":null,"freeTrialPrivilege":{"resConsumable":false,"userConsumable":false},"chargeInfoList":[{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":0},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]}
     */
    private String musicId;
    private String musicUrl;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    private String name;
    private int id;
    private int pst;
    private int t;
    private int pop;
    private int st;
    private String rt;
    private int fee;
    private int v;
    private Object crbt;
    private String cf;
    private AlBean al;
    private int dt;
    private HBean h;
    private MBean m;
    private LBean l;
    private Object a;
    private String cd;
    private int no;
    private Object rtUrl;
    private int ftype;
    private int djId;
    private int copyright;
    private int s_id;
    private int mark;
    private int originCoverType;
    private Object originSongSimpleData;
    private boolean resourceState;
    private int version;
    private int single;
    private Object noCopyrightRcmd;
    private int rtype;
    private Object rurl;
    private int mst;
    private int cp;
    private int mv;
    private long publishTime;
    private PrivilegeBean privilege;
    private List<ArBean> ar;
    private List<?> alia;
    private List<?> rtUrls;
    private List<String> tns;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @lombok.Data
    public static class AlBean implements Serializable {
        /**
         * id : 34110
         * name : Beyond 25th Anniversary
         * picUrl : http://p4.music.126.net/zZtUDuWk6qIe3ezMt4UMjg==/109951165796417308.jpg
         * tns : []
         * pic_str : 109951165796417308
         * pic : 109951165796417310
         */

        private int id;
        private String name;
        private String picUrl;
        private String pic_str;
        private long pic;
        private List<?> tns;
    }

//    @lombok.Data
    public static class HBean implements Serializable {
        /**
         * br : 320000
         * fid : 0
         * size : 12905577
         * vd : -25300
         */

        private int br;
        private int fid;
        private int size;
        private int vd;
    }

//    @lombok.Data
    public static class MBean implements Serializable {
        /**
         * br : 192000
         * fid : 0
         * size : 7743363
         * vd : -22800
         */

        private int br;
        private int fid;
        private int size;
        private int vd;
    }

//    @lombok.Data
    public static class LBean implements Serializable {
        /**
         * br : 128000
         * fid : 0
         * size : 5162256
         * vd : -21300
         */

        private int br;
        private int fid;
        private int size;
        private int vd;
    }

//    @lombok.Data
    public static class PrivilegeBean implements Serializable {
        /**
         * id : 346089
         * fee : 8
         * payed : 0
         * st : 0
         * pl : 128000
         * dl : 0
         * sp : 7
         * cp : 1
         * subp : 1
         * cs : false
         * maxbr : 999000
         * fl : 128000
         * toast : false
         * flag : 256
         * preSell : false
         * playMaxbr : 999000
         * downloadMaxbr : 999000
         * rscl : null
         * freeTrialPrivilege : {"resConsumable":false,"userConsumable":false}
         * chargeInfoList : [{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":0},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]
         */

        private int id;
        private int fee;
        private int payed;
        private int st;
        private int pl;
        private int dl;
        private int sp;
        private int cp;
        private int subp;
        private boolean cs;
        private int maxbr;
        private int fl;
        private boolean toast;
        private int flag;
        private boolean preSell;
        private int playMaxbr;
        private int downloadMaxbr;
        private Object rscl;
        private FreeTrialPrivilegeBean freeTrialPrivilege;
        private List<ChargeInfoListBean> chargeInfoList;

//        @lombok.Data
        public static class FreeTrialPrivilegeBean implements Serializable {
            /**
             * resConsumable : false
             * userConsumable : false
             */

            private boolean resConsumable;
            private boolean userConsumable;
        }

//        @lombok.Data
        public static class ChargeInfoListBean implements Serializable {
            /**
             * rate : 128000
             * chargeUrl : null
             * chargeMessage : null
             * chargeType : 0
             */

            private int rate;
            private Object chargeUrl;
            private Object chargeMessage;
            private int chargeType;
        }
    }

//    @lombok.Data
    public static class ArBean implements Serializable {
        /**
         * id : 11127
         * name : Beyond
         * tns : []
         * alias : ["超越"]
         * alia : ["超越"]
         */

        private int id;
        private String name;
        private List<?> tns;
        private List<String> alias;
        private List<String> alia;
    }
}
