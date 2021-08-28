package com.example.wyy.main.top;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wyy.R;
import com.example.wyy.adapters.top.TopAdapter;
import com.example.wyy.classes.SelectClass.Select;
import com.example.wyy.classes.TopClass.Top;
import com.example.wyy.classes.TopClass.Tops;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    String address;
    TopAdapter topAdapter;
    List<Top> topList=new ArrayList<>();
    List<Tops> topsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        recyclerView=findViewById(R.id.top_recycle);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull  RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void getItemOffsets(@NonNull Rect outRect, View view, @NonNull  RecyclerView parent, @NonNull  RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(30,30,30,15);
            }
        });
        update();
        topAdapter=new TopAdapter(topList);
        recyclerView.setAdapter(topAdapter);
    }

    private void update() {
        address= Strings.TOP;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
//                Log.d("SSSSSSSSSSSS","正在进行");
                topsList=new JsonUtil().JsonTop(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < topsList.size(); i++) {
                            Top sList=new Top(topsList.get(i).getName(),topsList.get(i).getCoverImgUrl(),topsList.get(i).getId(),topsList.get(i).getDescription());
//                            Log.d("SELECTNAME",sList.getName());
                            topList.add(sList);
                        }
                        topAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(topAdapter);
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