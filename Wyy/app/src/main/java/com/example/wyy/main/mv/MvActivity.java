package com.example.wyy.main.mv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.wyy.R;
import com.example.wyy.classes.SongClass.SList;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

public class MvActivity extends AppCompatActivity {
    String address,id,url,mvUrl;
    VideoView videoView;
    MediaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mv);
        update();
    }
    private void update() {
        Intent intent=getIntent();
        id=intent.getStringExtra(Strings.ID);
        address= Strings.MV+id;
        Log.d("NNNNNNNNNNNN",address);
        /*Log.d("ssid",id);*/
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("sssssssssssss","正在进行");
                url=new JsonUtil().JsonMvUrl(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mvUrl=url;
                         videoView=findViewById(R.id.mv_videoView);
                        videoView.setVideoURI(Uri.parse(mvUrl));
                        controller=new MediaController(MvActivity.this);
                        videoView.setMediaController(controller);
                        videoView.start();
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("LLLLLLLL","请求失败");
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        videoView.pause();
    }
}