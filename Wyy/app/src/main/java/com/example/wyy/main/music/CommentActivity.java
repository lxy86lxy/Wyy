package com.example.wyy.main.music;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.View;

import com.example.wyy.R;
import com.example.wyy.adapters.comment.CommentAdapter;
import com.example.wyy.adapters.word.WordAdapter;
import com.example.wyy.classes.CommentClass.Comments;
import com.example.wyy.classes.CommentClass.Coo;
import com.example.wyy.classes.lyric.Word;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Comments> commentsList = new ArrayList<>();
    private Comments comments;
    private List<Coo> cooList=new ArrayList<>();
    private String address, id;
    CommentAdapter commentAdapter;
    LinearLayoutManager linearLayoutManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        getWindow().setEnterTransition(new Fade().setDuration(1000));
        getWindow().setExitTransition(new Fade().setDuration(1000));
        recyclerView = findViewById(R.id.music_comment_recycle);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //分割线
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull  Canvas c, @NonNull RecyclerView parent, @NonNull  RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint=new Paint();
                paint.setColor(Color.GRAY);
                c.drawRect(0,0,0,100,paint);
            }

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull  View view, @NonNull  RecyclerView parent, @NonNull  RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(50,50,50,20);
            }
        });
        update();
        commentAdapter = new CommentAdapter(commentsList);
        recyclerView.setAdapter(commentAdapter);
    }

    private void update() {
        Intent intent = getIntent();
        id = intent.getStringExtra("ly");
        address = Strings.COMMENT + id;
        Log.d("XXXXXXXX",address);
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("PPPPPPPPPPPPPPPPPPPP","进入了");
                cooList = new JsonUtil().JsonComment(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < cooList.size(); i++) {
                            comments=new Comments(cooList.get(i).getNickname(),cooList.get(i).getAvatarUrl(),cooList.get(i).getContent());
                            commentsList.add(comments);
                        }
                        commentAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(commentAdapter);
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("CCCCCCCCC", "请求失败");
            }
        });
    }
}