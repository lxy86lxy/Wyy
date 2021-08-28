package com.example.wyy.classes.SongClass;

import java.io.Serializable;
import java.util.List;
/*
@lombok.Data*/
public class SLists implements Serializable {

    /**
     * name : 你值得更好的
     * id : 1867936253
     * pst : 0
     * t : 0
     * ar : [{"id":6472,"name":"张杰","tns":[],"alias":[]}]
     * alia : []
     * pop : 100
     * st : 0
     * rt :
     * fee : 8
     * v : 5
     * crbt : null
     * cf :
     * al : {"id":131506388,"name":"值得更好的","picUrl":"http://p4.music.126.net/KS0TddHKX8c3atG3CkmdUw==/109951166264542938.jpg","tns":[],"pic_str":"109951166264542938","pic":109951166264542940}
     * dt : 263607
     * h : {"br":320000,"fid":0,"size":10546605,"vd":-48459}
     * m : {"br":192000,"fid":0,"size":6327981,"vd":-45833}
     * l : {"br":128000,"fid":0,"size":4218669,"vd":-44104}
     * a : null
     * cd : 01
     * no : 1
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * djId : 0
     * copyright : 0
     * s_id : 0
     * mark : 8192
     * originCoverType : 0
     * originSongSimpleData : null
     * single : 0
     * noCopyrightRcmd : null
     * rtype : 0
     * rurl : null
     * mst : 9
     * cp : 1418037
     * mv : 14306186
     * publishTime : 0
     * alg : alg_featured
     */
    private String author;
    private String picUrl;
    private String musicId;
    private String allPic;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    private int single;
    private Object noCopyrightRcmd;
    private int rtype;
    private Object rurl;
    private int mst;
    private int cp;
    private int mv;
    private int publishTime;
    private String alg;
    private List<ArBean> ar;
    private List<?> alia;
    private List<?> rtUrls;

   /* @lombok.Data*/
    public static class AlBean implements Serializable {
        /**
         * id : 131506388
         * name : 值得更好的
         * picUrl : http://p4.music.126.net/KS0TddHKX8c3atG3CkmdUw==/109951166264542938.jpg
         * tns : []
         * pic_str : 109951166264542938
         * pic : 109951166264542940
         */

        private int id;
        private String name;
        private String picUrl;
        private String pic_str;
        private long pic;
        private List<?> tns;
    }

   /* @lombok.Data*/
    public static class HBean implements Serializable {
        /**
         * br : 320000
         * fid : 0
         * size : 10546605
         * vd : -48459
         */

        private int br;
        private int fid;
        private int size;
        private int vd;
    }
/*
    @lombok.Data*/
    public static class MBean implements Serializable {
        /**
         * br : 192000
         * fid : 0
         * size : 6327981
         * vd : -45833
         */

        private int br;
        private int fid;
        private int size;
        private int vd;
    }

   /* @lombok.Data*/
    public static class LBean implements Serializable {
        /**
         * br : 128000
         * fid : 0
         * size : 4218669
         * vd : -44104
         */

        private int br;
        private int fid;
        private int size;
        private int vd;
    }

    /*@lombok.Data*/
    public  class ArBean implements Serializable {
        /**
         * id : 6472
         * name : 张杰
         * tns : []
         * alias : []
         */

        private int id;
        private String name;
        private List<?> tns;
        private List<?> alias;

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

        public List<?> getTns() {
            return tns;
        }

        public void setTns(List<?> tns) {
            this.tns = tns;
        }

        public List<?> getAlias() {
            return alias;
        }

        public void setAlias(List<?> alias) {
            this.alias = alias;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPst() {
        return pst;
    }

    public void setPst(int pst) {
        this.pst = pst;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Object getCrbt() {
        return crbt;
    }

    public void setCrbt(Object crbt) {
        this.crbt = crbt;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public AlBean getAl() {
        return al;
    }

    public void setAl(AlBean al) {
        this.al = al;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public HBean getH() {
        return h;
    }

    public void setH(HBean h) {
        this.h = h;
    }

    public MBean getM() {
        return m;
    }

    public void setM(MBean m) {
        this.m = m;
    }

    public LBean getL() {
        return l;
    }

    public void setL(LBean l) {
        this.l = l;
    }

    public Object getA() {
        return a;
    }

    public void setA(Object a) {
        this.a = a;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Object getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(Object rtUrl) {
        this.rtUrl = rtUrl;
    }

    public int getFtype() {
        return ftype;
    }

    public void setFtype(int ftype) {
        this.ftype = ftype;
    }

    public int getDjId() {
        return djId;
    }

    public void setDjId(int djId) {
        this.djId = djId;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getOriginCoverType() {
        return originCoverType;
    }

    public void setOriginCoverType(int originCoverType) {
        this.originCoverType = originCoverType;
    }

    public Object getOriginSongSimpleData() {
        return originSongSimpleData;
    }

    public void setOriginSongSimpleData(Object originSongSimpleData) {
        this.originSongSimpleData = originSongSimpleData;
    }

    public int getSingle() {
        return single;
    }

    public void setSingle(int single) {
        this.single = single;
    }

    public Object getNoCopyrightRcmd() {
        return noCopyrightRcmd;
    }

    public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
        this.noCopyrightRcmd = noCopyrightRcmd;
    }

    public int getRtype() {
        return rtype;
    }

    public void setRtype(int rtype) {
        this.rtype = rtype;
    }

    public Object getRurl() {
        return rurl;
    }

    public void setRurl(Object rurl) {
        this.rurl = rurl;
    }

    public int getMst() {
        return mst;
    }

    public void setMst(int mst) {
        this.mst = mst;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getMv() {
        return mv;
    }

    public void setMv(int mv) {
        this.mv = mv;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public List<ArBean> getAr() {
        return ar;
    }

    public void setAr(List<ArBean> ar) {
        this.ar = ar;
    }

    public List<?> getAlia() {
        return alia;
    }

    public void setAlia(List<?> alia) {
        this.alia = alia;
    }

    public List<?> getRtUrls() {
        return rtUrls;
    }

    public void setRtUrls(List<?> rtUrls) {
        this.rtUrls = rtUrls;
    }
}
