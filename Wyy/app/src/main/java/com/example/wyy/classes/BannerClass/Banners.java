package com.example.wyy.classes.BannerClass;

import java.io.Serializable;
import java.util.List;


public class Banners implements Serializable {

    /**
     * pic : http://p1.music.126.net/D7JoTbsvFxDjaUsmd5mdXA==/109951166298213618.jpg
     * targetId : 1868874994
     * adid : null
     * targetType : 1
     * titleColor : red
     * typeTitle : 新歌首发
     * url : null
     * adurlV2 : null
     * exclusive : false
     * monitorImpress : null
     * monitorClick : null
     * monitorType : null
     * monitorImpressList : []
     * monitorClickList : []
     * monitorBlackList : null
     * extMonitor : null
     * extMonitorInfo : null
     * adSource : null
     * adLocation : null
     * encodeId : 1868874994
     * program : null
     * event : null
     * video : null
     * dynamicVideoData : null
     * song : {"name":"心动","id":1868874994,"pst":0,"t":0,"ar":[{"id":1085047,"name":"棱镜","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":3,"crbt":null,"cf":"","al":{"id":131679303,"name":"心动","picUrl":"http://p4.music.126.net/6qHEz6cFxbxhSIQwsEimrw==/109951166279509814.jpg","tns":[],"pic_str":"109951166279509814","pic":109951166279509810},"dt":239097,"h":{"br":320002,"fid":0,"size":9566085,"vd":-42187},"m":{"br":192002,"fid":0,"size":5739668,"vd":-39556},"l":{"br":128002,"fid":0,"size":3826460,"vd":-37824},"a":null,"cd":"01","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":0,"s_id":0,"mark":0,"originCoverType":0,"originSongSimpleData":null,"single":0,"noCopyrightRcmd":null,"mst":9,"cp":0,"mv":0,"rtype":0,"rurl":null,"publishTime":0,"privilege":{"id":1868874994,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":64,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000,"rscl":null,"freeTrialPrivilege":{"resConsumable":false,"userConsumable":false},"chargeInfoList":[{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":0},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]}}
     * bannerId : 1629307553201390
     * alg : null
     * scm : 1.music-homepage.homepage_banner_force.banner.3148986.1286914525.null
     * requestId :
     * showAdTag : true
     * pid : null
     * showContext : null
     * adDispatchJson : null
     */

    private String pic;
    private int targetId;
    private Object adid;
    private int targetType;
    private String titleColor;
    private String typeTitle;
    private Object url;
    private Object adurlV2;
    private boolean exclusive;
    private Object monitorImpress;
    private Object monitorClick;
    private Object monitorType;
    private Object monitorBlackList;
    private Object extMonitor;
    private Object extMonitorInfo;
    private Object adSource;
    private Object adLocation;
    private String encodeId;
    private Object program;
    private Object event;
    private Object video;
    private Object dynamicVideoData;
    private SongBean song;
    private String bannerId;
    private Object alg;
    private String scm;
    private String requestId;
    private boolean showAdTag;
    private Object pid;
    private Object showContext;
    private Object adDispatchJson;
    private List<?> monitorImpressList;
    private List<?> monitorClickList;


    public static class SongBean implements Serializable {
        /**
         * name : 心动
         * id : 1868874994
         * pst : 0
         * t : 0
         * ar : [{"id":1085047,"name":"棱镜","tns":[],"alias":[]}]
         * alia : []
         * pop : 100
         * st : 0
         * rt :
         * fee : 8
         * v : 3
         * crbt : null
         * cf :
         * al : {"id":131679303,"name":"心动","picUrl":"http://p4.music.126.net/6qHEz6cFxbxhSIQwsEimrw==/109951166279509814.jpg","tns":[],"pic_str":"109951166279509814","pic":109951166279509810}
         * dt : 239097
         * h : {"br":320002,"fid":0,"size":9566085,"vd":-42187}
         * m : {"br":192002,"fid":0,"size":5739668,"vd":-39556}
         * l : {"br":128002,"fid":0,"size":3826460,"vd":-37824}
         * a : null
         * cd : 01
         * no : 1
         * rtUrl : null
         * ftype : 0
         * rtUrls : []
         * djId : 0
         * copyright : 0
         * s_id : 0
         * mark : 0
         * originCoverType : 0
         * originSongSimpleData : null
         * single : 0
         * noCopyrightRcmd : null
         * mst : 9
         * cp : 0
         * mv : 0
         * rtype : 0
         * rurl : null
         * publishTime : 0
         * privilege : {"id":1868874994,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":64,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000,"rscl":null,"freeTrialPrivilege":{"resConsumable":false,"userConsumable":false},"chargeInfoList":[{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":0},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]}
         */

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
        private int mst;
        private int cp;
        private int mv;
        private int rtype;
        private Object rurl;
        private int publishTime;
        private PrivilegeBean privilege;
        private List<ArBean> ar;
        private List<?> alia;
        private List<?> rtUrls;

//        @lombok.Data
        public static class AlBean implements Serializable {
            /**
             * id : 131679303
             * name : 心动
             * picUrl : http://p4.music.126.net/6qHEz6cFxbxhSIQwsEimrw==/109951166279509814.jpg
             * tns : []
             * pic_str : 109951166279509814
             * pic : 109951166279509810
             */

            private int id;
            private String name;
            private String picUrl;
            private String pic_str;
            private long pic;
            private List<?> tns;
        }

//        @lombok.Data
        public static class HBean implements Serializable {
            /**
             * br : 320002
             * fid : 0
             * size : 9566085
             * vd : -42187
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
        }
//
//        @lombok.Data
        public static class MBean implements Serializable {
            /**
             * br : 192002
             * fid : 0
             * size : 5739668
             * vd : -39556
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
        }

//        @lombok.Data
        public static class LBean implements Serializable {
            /**
             * br : 128002
             * fid : 0
             * size : 3826460
             * vd : -37824
             */

            private int br;
            private int fid;
            private int size;
            private int vd;
        }

//        @lombok.Data
        public static class PrivilegeBean implements Serializable {
            /**
             * id : 1868874994
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
             * flag : 64
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
//
//            @lombok.Data
            public static class FreeTrialPrivilegeBean implements Serializable {
                /**
                 * resConsumable : false
                 * userConsumable : false
                 */

                private boolean resConsumable;
                private boolean userConsumable;
            }

//            @lombok.Data
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

//        @lombok.Data
        public static class ArBean implements Serializable {
            /**
             * id : 1085047
             * name : 棱镜
             * tns : []
             * alias : []
             */

            private int id;
            private String name;
            private List<?> tns;
            private List<?> alias;
        }
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public Object getAdid() {
        return adid;
    }

    public void setAdid(Object adid) {
        this.adid = adid;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Object getAdurlV2() {
        return adurlV2;
    }

    public void setAdurlV2(Object adurlV2) {
        this.adurlV2 = adurlV2;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public void setExclusive(boolean exclusive) {
        this.exclusive = exclusive;
    }

    public Object getMonitorImpress() {
        return monitorImpress;
    }

    public void setMonitorImpress(Object monitorImpress) {
        this.monitorImpress = monitorImpress;
    }

    public Object getMonitorClick() {
        return monitorClick;
    }

    public void setMonitorClick(Object monitorClick) {
        this.monitorClick = monitorClick;
    }

    public Object getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Object monitorType) {
        this.monitorType = monitorType;
    }

    public Object getMonitorBlackList() {
        return monitorBlackList;
    }

    public void setMonitorBlackList(Object monitorBlackList) {
        this.monitorBlackList = monitorBlackList;
    }

    public Object getExtMonitor() {
        return extMonitor;
    }

    public void setExtMonitor(Object extMonitor) {
        this.extMonitor = extMonitor;
    }

    public Object getExtMonitorInfo() {
        return extMonitorInfo;
    }

    public void setExtMonitorInfo(Object extMonitorInfo) {
        this.extMonitorInfo = extMonitorInfo;
    }

    public Object getAdSource() {
        return adSource;
    }

    public void setAdSource(Object adSource) {
        this.adSource = adSource;
    }

    public Object getAdLocation() {
        return adLocation;
    }

    public void setAdLocation(Object adLocation) {
        this.adLocation = adLocation;
    }

    public String getEncodeId() {
        return encodeId;
    }

    public void setEncodeId(String encodeId) {
        this.encodeId = encodeId;
    }

    public Object getProgram() {
        return program;
    }

    public void setProgram(Object program) {
        this.program = program;
    }

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = video;
    }

    public Object getDynamicVideoData() {
        return dynamicVideoData;
    }

    public void setDynamicVideoData(Object dynamicVideoData) {
        this.dynamicVideoData = dynamicVideoData;
    }

    public SongBean getSong() {
        return song;
    }

    public void setSong(SongBean song) {
        this.song = song;
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public Object getAlg() {
        return alg;
    }

    public void setAlg(Object alg) {
        this.alg = alg;
    }

    public String getScm() {
        return scm;
    }

    public void setScm(String scm) {
        this.scm = scm;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isShowAdTag() {
        return showAdTag;
    }

    public void setShowAdTag(boolean showAdTag) {
        this.showAdTag = showAdTag;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public Object getShowContext() {
        return showContext;
    }

    public void setShowContext(Object showContext) {
        this.showContext = showContext;
    }

    public Object getAdDispatchJson() {
        return adDispatchJson;
    }

    public void setAdDispatchJson(Object adDispatchJson) {
        this.adDispatchJson = adDispatchJson;
    }

    public List<?> getMonitorImpressList() {
        return monitorImpressList;
    }

    public void setMonitorImpressList(List<?> monitorImpressList) {
        this.monitorImpressList = monitorImpressList;
    }

    public List<?> getMonitorClickList() {
        return monitorClickList;
    }

    public void setMonitorClickList(List<?> monitorClickList) {
        this.monitorClickList = monitorClickList;
    }
}
