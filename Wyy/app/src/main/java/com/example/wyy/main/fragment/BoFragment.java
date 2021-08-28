package com.example.wyy.main.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wyy.R;
import com.example.wyy.adapters.mv.MvAdapter;
import com.example.wyy.classes.MvClass.Mm;
import com.example.wyy.classes.MvClass.Mms;
import com.example.wyy.classes.SongClass.SList;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class BoFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    String address,id;
    MvAdapter mvAdapter;
    List<Mm>mmList=new ArrayList<>();
    List<Mms> mmsList=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View cow= inflater.inflate(R.layout.fragment_bo, container, false);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView=cow.findViewById(R.id.bo_recycle);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        update();
        mvAdapter=new MvAdapter(mmList);
        recyclerView.setAdapter(mvAdapter);
        return cow;
    }

    private void update() {
        address= Strings.BO_MV;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("OOOOOOOOOOOO","正在进行");
                mmsList=new JsonUtil().JsonMv(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < mmsList.size(); i++) {
                           Mm sList=new Mm(mmsList.get(i).getId(),mmsList.get(i).getCover(),mmsList.get(i).getName());
                            mmList.add(sList);
                        }
                        mvAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(mvAdapter);
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