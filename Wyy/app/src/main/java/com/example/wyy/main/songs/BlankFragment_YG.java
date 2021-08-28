package com.example.wyy.main.songs;

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
import com.example.wyy.adapters.find3.FindAdapterThree;
import com.example.wyy.classes.FindClass.FindSong;
import com.example.wyy.classes.FindClass.FindSongs;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment_YG extends Fragment {
    String address;
    RecyclerView recyclerView;//歌单华语
    FindAdapterThree findAdapterThree;
    LinearLayoutManager linearLayoutManager;
    private List<FindSongs> findSongsList=new ArrayList<>();
    private List<FindSong> findSongList=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View cow= inflater.inflate(R.layout.fragment_blank__y_g, container, false);
        recyclerView=cow.findViewById(R.id.song_yg_recycle);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        updataList();
        findAdapterThree=new FindAdapterThree(findSongList,getActivity());
        recyclerView.setAdapter(findAdapterThree);
        return cow;
    }
    //歌单
    private void updataList(){
        address= Strings.FIND_YG;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("sssssssssssss","正在进行");
                findSongsList=new JsonUtil().JsonFindSongs(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < findSongsList.size(); i++) {
                            FindSong findSong=new FindSong(findSongsList.get(i).getCoverImgUrl(),findSongsList.get(i).getName(),findSongsList.get(i).getId());
                            findSongList.add(findSong);
                        }
                        findAdapterThree.notifyDataSetChanged();
                        recyclerView.setAdapter(findAdapterThree);
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