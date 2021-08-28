package com.example.wyy.main.select;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.wyy.R;
import com.example.wyy.adapters.select.SelectAdapter;
import com.example.wyy.classes.other.RecyclerViewOnScrollListener;
import com.example.wyy.classes.SelectClass.Select;
import com.example.wyy.classes.SelectClass.Selects;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class SelectKey  extends AppCompatActivity {
    String id;//返回的id
    String address,key;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    LinearLayoutManager linearLayoutManager;
    SelectAdapter selectAdapter;
    List<Select> sListList=new ArrayList<>();
    List<Selects> sListsList=new ArrayList<>();
    private static int count=0;
    int x;
    private RecyclerViewOnScrollListener.UpPullOnScrollListener onScrollListener=new RecyclerViewOnScrollListener.UpPullOnScrollListener() {
        //上拉
        @Override
        public void onLoadMore() {
            count++;
            updata();
        }
        //下拉
        @SuppressLint("ResourceAsColor")
        @Override
        public void onRefresh() {
            count++;
            swipeRefreshLayout.setEnabled(true);
            //加颜色
            swipeRefreshLayout.setColorSchemeColors(R.color.teal_700,R.color.teal_200);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("RRRRRRRRRRRRRRRR","成功");
                            sListList.clear();
                            updata1();
                            swipeRefreshLayout.setRefreshing(false);
                            Toast.makeText(SelectKey.this,"刷新成功！",Toast.LENGTH_SHORT).show();
                        }
                    },2000);
                }
            });

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        recyclerView=findViewById(R.id.select_recycle);
        swipeRefreshLayout=findViewById(R.id.select_swiper);
        recyclerView.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollListener));
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull  RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }

            @Override
            public void getItemOffsets(@NonNull Rect outRect,  View view, @NonNull  RecyclerView parent, @NonNull  RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10,10,10,5);
            }
        });
        updata();
        selectAdapter=new SelectAdapter(sListList);
        recyclerView.setAdapter(selectAdapter);
        recyclerView.setFocusableInTouchMode(false);
    }

    private void updata() {
        Intent intent=getIntent();
        key=intent.getStringExtra("name");
        int p=count*30;
        address= Strings.FIND_SELECT+key+Strings.FIND_SELECT_OFFSET+p;
        Log.d("ssid123",key);
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("SSSSSSSSSSSS","正在进行");
                sListsList=new JsonUtil().JsonSelect(response);
                /* Log.d("VVVVVVVVVVVVVVVVVV",sListsList.get(0).getAuthor());*/
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Log.d("VVVVVVVVVVVV","进去");
                        for (int i = 0; i < sListsList.size(); i++) {
                            Select sList=new Select(sListsList.get(i).getName(),sListsList.get(i).getAuthor(),sListsList.get(i).getMusicUrl(),sListsList.get(i).getMusicId());
                            sListList.add(sList);
                        }
                        x=linearLayoutManager.findLastCompletelyVisibleItemPosition();
                        selectAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(selectAdapter);
                        recyclerView.scrollToPosition(x);
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("AAAAA","请求失败");
            }
        });
    }
    private void updata1() {
        Intent intent=getIntent();
        key=intent.getStringExtra("name");
        int p=count*30;
        address= Strings.FIND_SELECT+key+Strings.FIND_SELECT_OFFSET+p;
        Log.d("ssid123",key);
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("SSSSSSSSSSSS","正在进行");
                sListsList=new JsonUtil().JsonSelect(response);
                /* Log.d("VVVVVVVVVVVVVVVVVV",sListsList.get(0).getAuthor());*/
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Log.d("VVVVVVVVVVVV","进去");
                        for (int i = 0; i < sListsList.size(); i++) {
                            Select sList=new Select(sListsList.get(i).getName(),sListsList.get(i).getAuthor(),sListsList.get(i).getMusicUrl(),sListsList.get(i).getMusicId());
                            sListList.add(sList);
                        }
                        selectAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(selectAdapter);
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
