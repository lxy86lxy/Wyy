package com.example.wyy.main.songs;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;

import com.example.wyy.R;
import com.example.wyy.adapters.song.SongListAdapter;
import com.example.wyy.classes.SongClass.SList;
import com.example.wyy.classes.SongClass.SLists;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class SongListActivity extends AppCompatActivity {
    String id;//返回的id
    String address;
    String url123;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    SongListAdapter songListAdapter;
    List<SList> sListList=new ArrayList<>();
    List<SLists> sListsList=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        getWindow().setEnterTransition(new Slide().setDuration(1000));
        getWindow().setExitTransition(new Slide().setDuration(2000));
        recyclerView=findViewById(R.id.songList_recycle);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        updata();
        Intent intent=getIntent();
        url123=intent.getStringExtra("url123");
        songListAdapter=new SongListAdapter(sListList,url123);
        recyclerView.setAdapter(songListAdapter);

    }

    private void updata() {
        Intent intent=getIntent();
        id=intent.getStringExtra(Strings.ID);
        address= Strings.HY+id;
        /*Log.d("ssid",id);*/
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("sssssssssssss","正在进行");
                sListsList=new JsonUtil().JsonSongList(response);
               runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < sListsList.size(); i++) {
                            SList sList=new SList(sListsList.get(i).getName(),sListsList.get(i).getAuthor(),sListsList.get(i).getPicUrl(),sListsList.get(i).getMusicId(),sListsList.get(i).getDescription(),sListsList.get(i).getAllPic(),sListsList.get(i).getTitleImageUrl());
                            sListList.add(sList);
                        }
                        songListAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(songListAdapter);
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("LLLLLLLL","请求失败");
            }
        });
    }
    }