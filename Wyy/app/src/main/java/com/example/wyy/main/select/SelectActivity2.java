package com.example.wyy.main.select;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.example.wyy.R;
import com.example.wyy.adapters.select.KeyAdapter;
import com.example.wyy.classes.SelectClass.Key;
import com.example.wyy.classes.SelectClass.Keys;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity2 extends AppCompatActivity {
    SearchView searchView;
    String key,address;
    RecyclerView recyclerView;
    KeyAdapter selectAdapter;
    LinearLayoutManager linearLayoutManager;
    List<Key> sListList=new ArrayList<>();
    List<Keys> sListsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select2);
        searchView=findViewById(R.id.find_search);
        recyclerView=findViewById(R.id.select2_recycle);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
     /*   updata();
        selectAdapter=new SelectAdapter(sListList);
        recyclerView.setAdapter(selectAdapter);*/

        //是否自动缩小图标
        searchView.setIconifiedByDefault(false);
        //是否显示搜索图标
        searchView.setSubmitButtonEnabled(true);
        //是否显示搜索文字
        searchView.setQueryHint("搜索");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单击搜索时触发
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent=new Intent(SelectActivity2.this, SelectActivity.class);
                Log.d("QUERY",query);
                intent.putExtra("keys",query);
                startActivity(intent);
                return false;
            }
            //输入文字触发
            @Override
            public boolean onQueryTextChange(String newText) {
                key=newText;
                sListList.clear();//关键清楚原来的
                    updata();
                    selectAdapter=new KeyAdapter(sListList);
                    recyclerView.setAdapter(selectAdapter);


                return false;
            }
        });
    }
    private void updata() {
        address= Strings.SELECT+key+ Strings.SELECT_NEXT;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                sListsList=new JsonUtil().JsonKey(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < sListsList.size(); i++) {
                            Key sList=new Key(sListsList.get(i).getName());
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