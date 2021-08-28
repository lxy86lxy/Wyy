package com.example.wyy.classes.FindClass;

import java.io.Serializable;
import java.util.List;


public class FindSongs implements Serializable {

    /**
     * name : 《向往的生活》第五季bgm全收录
     * id : 6709679621
     * trackNumberUpdateTime : 1627689407176
     * status : 0
     * userId : 1949164229
     * createTime : 1618281570561
     * updateTime : 1627689436773
     * subscribedCount : 6997
     * trackCount : 271
     * cloudTrackCount : 0
     * coverImgUrl : http://p1.music.126.net/ePetiNIkeCysWX-5xCXEIg==/109951165886997627.jpg
     * coverImgId : 109951165886997630
     * description : 《向往的生活第五季》已经开播啦，由黄磊、何炅、彭昱畅、张子枫、张艺兴担任固定主持。

     节目中蘑菇屋的五位成员在在这平凡又珍贵的日子里，携手嘉宾吃饭、锻炼、读书、生活。

     我们在一起，就是向往的生活

     这里收录向往的生活第五季bgm以及家人们哼唱的歌
     「持续实时更新」
     * tags : ["流行","综艺","影视原声"]
     * playCount : 684833
     * trackUpdateTime : 1629173057888
     * specialType : 0
     * totalDuration : 0
     * creator : {"defaultAvatar":false,"province":440000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/LwVfh2Kb3_yva5uXQmr6Jg==/109951166181529114.jpg","accountStatus":0,"gender":2,"city":440300,"birthday":668880000000,"userId":1949164229,"userType":200,"nickname":"马儿aimily","signature":"剧综达人，影视剧 综艺ost&bgm爱好者","description":"","detailDescription":"","avatarImgId":109951166181529120,"backgroundImgId":109951162868128400,"backgroundUrl":"http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"authenticationTypes":64,"avatarDetail":{"userType":200,"identityLevel":1,"identityIconUrl":"https://p5.music.126.net/obj/wo3DlcOGw6DClTvDisK1/4761340149/f4bf/64a1/1ea2/31a08617d7dfddb21fffdb92390ce268.png"},"anchor":false,"avatarImgIdStr":"109951166181529114","backgroundImgIdStr":"109951162868128395","avatarImgId_str":"109951166181529114"}
     * tracks : null
     * subscribers : [{"defaultAvatar":false,"province":430000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/2ijR4rpJju0KOBYn39IhZA==/19060034067882842.jpg","accountStatus":0,"gender":1,"city":431000,"birthday":631123200000,"userId":488021885,"userType":0,"nickname":"WHHVLX","signature":"","description":"","detailDescription":"","avatarImgId":19060034067882840,"backgroundImgId":109951162868126480,"backgroundUrl":"http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":11,"remarkName":null,"authenticationTypes":0,"avatarDetail":null,"anchor":false,"avatarImgIdStr":"19060034067882842","backgroundImgIdStr":"109951162868126486","avatarImgId_str":"19060034067882842"}]
     * subscribed : null
     * commentThreadId : A_PL_0_6709679621
     * newImported : false
     * adType : 0
     * highQuality : false
     * privacy : 0
     * ordered : true
     * anonimous : false
     * coverStatus : 3
     * recommendInfo : null
     * shareCount : 25
     * coverImgId_str : 109951165886997627
     * alg : alg_sq_topn_lr
     * commentCount : 96
     */

    private String name;
    private String id;
    private long trackNumberUpdateTime;
    private int status;
    private int userId;
    private long createTime;
    private long updateTime;
    private int subscribedCount;
    private int trackCount;
    private int cloudTrackCount;
    private String coverImgUrl;
    private long coverImgId;
    private String description;
    private int playCount;
    private long trackUpdateTime;
    private int specialType;
    private int totalDuration;
    private CreatorBean creator;
    private Object tracks;
    private Object subscribed;
    private String commentThreadId;
    private boolean newImported;
    private int adType;
    private boolean highQuality;
    private int privacy;
    private boolean ordered;
    private boolean anonimous;
    private int coverStatus;
    private Object recommendInfo;
    private int shareCount;
    private String coverImgId_str;
    private String alg;
    private int commentCount;
    private List<String> tags;
    private List<SubscribersBean> subscribers;


    public static class CreatorBean implements Serializable {
        /**
         * defaultAvatar : false
         * province : 440000
         * authStatus : 0
         * followed : false
         * avatarUrl : http://p1.music.126.net/LwVfh2Kb3_yva5uXQmr6Jg==/109951166181529114.jpg
         * accountStatus : 0
         * gender : 2
         * city : 440300
         * birthday : 668880000000
         * userId : 1949164229
         * userType : 200
         * nickname : 马儿aimily
         * signature : 剧综达人，影视剧 综艺ost&bgm爱好者
         * description :
         * detailDescription :
         * avatarImgId : 109951166181529120
         * backgroundImgId : 109951162868128400
         * backgroundUrl : http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg
         * authority : 0
         * mutual : false
         * expertTags : null
         * experts : null
         * djStatus : 0
         * vipType : 11
         * remarkName : null
         * authenticationTypes : 64
         * avatarDetail : {"userType":200,"identityLevel":1,"identityIconUrl":"https://p5.music.126.net/obj/wo3DlcOGw6DClTvDisK1/4761340149/f4bf/64a1/1ea2/31a08617d7dfddb21fffdb92390ce268.png"}
         * anchor : false
         * avatarImgIdStr : 109951166181529114
         * backgroundImgIdStr : 109951162868128395
         * avatarImgId_str : 109951166181529114
         */

        private boolean defaultAvatar;
        private int province;
        private int authStatus;
        private boolean followed;
        private String avatarUrl;
        private int accountStatus;
        private int gender;
        private int city;
        private long birthday;
        private int userId;
        private int userType;
        private String nickname;
        private String signature;
        private String description;
        private String detailDescription;
        private long avatarImgId;
        private long backgroundImgId;
        private String backgroundUrl;
        private int authority;
        private boolean mutual;
        private Object expertTags;
        private Object experts;
        private int djStatus;
        private int vipType;
        private Object remarkName;
        private int authenticationTypes;
        private AvatarDetailBean avatarDetail;
        private boolean anchor;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String avatarImgId_str;


        public static class AvatarDetailBean implements Serializable {
            /**
             * userType : 200
             * identityLevel : 1
             * identityIconUrl : https://p5.music.126.net/obj/wo3DlcOGw6DClTvDisK1/4761340149/f4bf/64a1/1ea2/31a08617d7dfddb21fffdb92390ce268.png
             */

            private int userType;
            private int identityLevel;
            private String identityIconUrl;
        }
    }


    public static class SubscribersBean implements Serializable {
        /**
         * defaultAvatar : false
         * province : 430000
         * authStatus : 0
         * followed : false
         * avatarUrl : http://p1.music.126.net/2ijR4rpJju0KOBYn39IhZA==/19060034067882842.jpg
         * accountStatus : 0
         * gender : 1
         * city : 431000
         * birthday : 631123200000
         * userId : 488021885
         * userType : 0
         * nickname : WHHVLX
         * signature :
         * description :
         * detailDescription :
         * avatarImgId : 19060034067882840
         * backgroundImgId : 109951162868126480
         * backgroundUrl : http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg
         * authority : 0
         * mutual : false
         * expertTags : null
         * experts : null
         * djStatus : 0
         * vipType : 11
         * remarkName : null
         * authenticationTypes : 0
         * avatarDetail : null
         * anchor : false
         * avatarImgIdStr : 19060034067882842
         * backgroundImgIdStr : 109951162868126486
         * avatarImgId_str : 19060034067882842
         */

        private boolean defaultAvatar;
        private int province;
        private int authStatus;
        private boolean followed;
        private String avatarUrl;
        private int accountStatus;
        private int gender;
        private int city;
        private long birthday;
        private int userId;
        private int userType;
        private String nickname;
        private String signature;
        private String description;
        private String detailDescription;
        private long avatarImgId;
        private long backgroundImgId;
        private String backgroundUrl;
        private int authority;
        private boolean mutual;
        private Object expertTags;
        private Object experts;
        private int djStatus;
        private int vipType;
        private Object remarkName;
        private int authenticationTypes;
        private Object avatarDetail;
        private boolean anchor;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String avatarImgId_str;
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

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public Object getTracks() {
        return tracks;
    }

    public void setTracks(Object tracks) {
        this.tracks = tracks;
    }

    public Object getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Object subscribed) {
        this.subscribed = subscribed;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public int getCoverStatus() {
        return coverStatus;
    }

    public void setCoverStatus(int coverStatus) {
        this.coverStatus = coverStatus;
    }

    public Object getRecommendInfo() {
        return recommendInfo;
    }

    public void setRecommendInfo(Object recommendInfo) {
        this.recommendInfo = recommendInfo;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public String getCoverImgId_str() {
        return coverImgId_str;
    }

    public void setCoverImgId_str(String coverImgId_str) {
        this.coverImgId_str = coverImgId_str;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<SubscribersBean> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<SubscribersBean> subscribers) {
        this.subscribers = subscribers;
    }
}

