package com.example.wyy.main.music;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.wyy.R;
import com.example.wyy.adapters.word.WordAdapter;
import com.example.wyy.classes.TopClass.Top;
import com.example.wyy.classes.lyric.Word;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

public class WordActivity extends AppCompatActivity {
RecyclerView recyclerView;
private Word word;
private String address,id,word1;
WordAdapter wordAdapter;
LinearLayoutManager linearLayoutManager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        getWindow().setEnterTransition(new Slide().setDuration(1000));
        getWindow().setExitTransition(new Slide().setDuration(1000));
        recyclerView=findViewById(R.id.music_word_recycle);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        update();


//        recyclerView.setAdapter(wordAdapter);
    }

    private void update() {
        Intent intent=getIntent();
        id=intent.getStringExtra("ly");
        address= Strings.WORD+id;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
        //        Log.d("SSSSSSSSSSSS","正在进行");
                word=new JsonUtil().JsonWord(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        word1=word.getLyric();
                        Log.d("TTTTTTTTTTTTTT",word1);
                        wordAdapter=new WordAdapter(word1);
                        wordAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(wordAdapter);
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("AAAAA","请求失败");
            }
        });
    }
    }
