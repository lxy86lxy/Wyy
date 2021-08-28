package com.example.wyy.util;

import android.util.Log;

import com.example.wyy.classes.BallClass.Balls;
import com.example.wyy.classes.BannerClass.Banners;
import com.example.wyy.classes.CommentClass.Comments;
import com.example.wyy.classes.CommentClass.Coo;
import com.example.wyy.classes.FindClass.FindSongs;
import com.example.wyy.classes.MusicUrlClass.Music;
import com.example.wyy.classes.MvClass.Mms;
import com.example.wyy.classes.SelectClass.Keys;
import com.example.wyy.classes.SelectClass.Selects;
import com.example.wyy.classes.SongClass.SLists;
import com.example.wyy.classes.TopClass.Tops;
import com.example.wyy.classes.lyric.Word;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    //解析歌单（网友精选碟）
    public List<FindSongs> JsonFindSongs(String jsonData) {
        List<FindSongs> findSongsList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("playlists");
           for (int i=0;i<jsonArray.length();i++){
               FindSongs findSongs=new FindSongs();
               JSONObject jsonObject1=jsonArray.getJSONObject(i);
               findSongs.setCoverImgUrl(jsonObject1.getString("coverImgUrl"));
               findSongs.setName(jsonObject1.getString("name"));
               findSongs.setId(jsonObject1.getString("id"));
               findSongsList.add(findSongs);
           }
            /* Gson gson = new Gson();
            findSongsList = gson.fromJson(jsonArray, new TypeToken<List<FindSongs>>() {
            }.getType());*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return findSongsList;
    }

    //banner
    public List<Banners> JsonBanners(String jsonData){
        List<Banners> bannersList=new ArrayList<>();
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("banners");
            for (int i = 0; i < jsonArray.length(); i++) {
                Banners banners=new Banners();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                banners.setPic(jsonObject1.getString("pic"));
                bannersList.add(banners);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return bannersList;
    }

    //ball界面上的小圆
    public  List<Balls> JsonBalls(String jsonData){
        List<Balls> ballsList=new ArrayList<>();
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                Balls balls=new Balls();
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                balls.setName(jsonObject1.getString("name"));
                balls.setIconUrl(jsonObject1.getString("iconUrl"));
                balls.setUrl(jsonObject1.getString("url"));
                ballsList.add(balls);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return ballsList;
    }

    //解析歌单里面的歌的详情
    public List<SLists> JsonSongList(String jsonData){
        List<SLists> sListsList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObject1=jsonObject.getJSONObject("playlist");
            JSONArray jsonArray=jsonObject1.getJSONArray("tracks");
            for (int i = 0; i < jsonArray.length(); i++) {
                SLists sLists=new SLists();
                sLists.setDescription(jsonObject1.getString("description"));
                sLists.setAllPic(jsonObject1.getString("backgroundCoverUrl"));
                sLists.setTitleImageUrl(jsonObject1.getString("titleImageUrl"));
//                Log.d("TTTTTTTTTTTT",sLists.getTitleImageUrl());
                JSONObject jsonObject2=jsonArray.getJSONObject(i);
                //name
                sLists.setName(jsonObject2.getString("name"));
                //musicId
                sLists.setMusicId(jsonObject2.getString("id"));
                JSONArray jsonArray1=jsonObject2.getJSONArray("ar");
                    //author
                    JSONObject jsonObject3=jsonArray1.getJSONObject(0);
                    sLists.setAuthor(jsonObject3.getString("name"));
                 JSONObject jsonObject4=jsonObject2.getJSONObject("al");
                 //图片链接
                 sLists.setPicUrl(jsonObject4.getString("picUrl"));
                sListsList.add(sLists);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return sListsList;
    }

    //解析音乐url
    public Music JsonMusic(String jsonData){
        Music musicList=new Music();
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            JSONObject jsonObject1=jsonArray.getJSONObject(0);
            musicList.setUrl(jsonObject1.getString("url"));
//            Log.d("BBBBBBBBBBBBBBBBBBBB",musicList.getUrl())没问题
        }catch (JSONException e){
            e.printStackTrace();
        }
        return musicList;
    }


    //解析搜索大全
    public List<Selects> JsonSelect(String jsonData){
        List<Selects> selectsList=new ArrayList<>();
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObject1=jsonObject.getJSONObject("result");
            JSONArray jsonArray=jsonObject1.getJSONArray("songs");
            for (int i = 0; i < jsonArray.length(); i++) {
                Selects selects=new Selects();
                JSONObject jsonObject2=jsonArray.getJSONObject(i);
                //音乐id
                selects.setMusicId(jsonObject2.getString("id"));
                //歌曲名字
                selects.setName(jsonObject2.getString("name"));
                JSONObject jsonObject3=jsonObject2.getJSONObject("al");
                //图片url
                selects.setMusicUrl(jsonObject3.getString("picUrl"));
                //歌手名字
                JSONArray jsonArray1=jsonObject2.getJSONArray("ar");
                JSONObject jsonObject4=jsonArray1.getJSONObject(0);
                selects.setAuthor(jsonObject4.getString("name"));
//                Log.d("AUTOR",selects.getAuthor());
                selectsList.add(selects);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return selectsList;
    }

    //搜索关键字出来
    public List<Keys> JsonKey(String jsonData){
        List<Keys>keysList=new ArrayList<>();
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObject1=jsonObject.getJSONObject("result");
            JSONArray jsonArray=jsonObject1.getJSONArray("allMatch");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2=jsonArray.getJSONObject(i);
                Keys keys=new Keys();
                keys.setName(jsonObject2.getString("keyword"));
                keysList.add(keys);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        return keysList;
    }

    //排行榜
    public List<Tops> JsonTop(String jsonData){
        List<Tops> topsList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                Tops tops=new Tops();
                tops.setName(jsonObject1.getString("name"));
                tops.setCoverImgUrl(jsonObject1.getString("coverImgUrl"));
                tops.setId(jsonObject1.getString("id"));
                tops.setDescription(jsonObject1.getString("description"));
                topsList.add(tops);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return topsList;
    }
    //歌词
    public Word JsonWord(String jsonData){
        Word word=new Word();
        try {
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObject1=jsonObject.getJSONObject("lrc");
            word.setLyric(jsonObject1.getString("lyric"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return word;
    }
    //评论
    public List<Coo> JsonComment(String jsonData){
//        Log.d("QQQQQQQQ","jinrule");
        List<Coo> commentsList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("hotComments");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                Coo comments=new Coo();
                JSONObject jsonObject2=jsonObject1.getJSONObject("user");
                comments.setNickname(jsonObject2.getString("nickname"));
//                Log.d("EEEEEEEE",comments.getNickname());
                comments.setAvatarUrl(jsonObject2.getString("avatarUrl"));
                comments.setContent(jsonObject1.getString("content"));
                commentsList.add(comments);

            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return commentsList;
    }
    //解析mv封面
    public List<Mms> JsonMv(String jsonData){
        List<Mms> mmsList=new ArrayList<>();
        try {
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                Mms mms=new Mms();
                mms.setId(jsonObject1.getString("id"));
                mms.setCover(jsonObject1.getString("cover"));
                mms.setName(jsonObject1.getString("name"));
                mmsList.add(mms);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return mmsList;
    }
    //解析mv的链接
    public String JsonMvUrl(String jsonData){
        String mv=null;
      try {
          JSONObject jsonObject=new JSONObject(jsonData);
          JSONObject jsonObject1=jsonObject.getJSONObject("data");
           mv=jsonObject1.getString("url");
      }catch (JSONException e){
          e.printStackTrace();
      }
      return mv;
    }
}

