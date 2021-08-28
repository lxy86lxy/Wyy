 package com.example.wyy.main.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.wyy.R;
import com.example.wyy.adapters.ball.BallAdapter;
import com.example.wyy.adapters.banner.BannerAdapter;
import com.example.wyy.adapters.find3.FindAdapterThree;
import com.example.wyy.adapters.top.TopsAdapter;
import com.example.wyy.classes.BallClass.Ball;
import com.example.wyy.classes.BallClass.Balls;
import com.example.wyy.classes.BannerClass.Banner;
import com.example.wyy.classes.BannerClass.Banners;
import com.example.wyy.classes.FindClass.FindSong;
import com.example.wyy.classes.FindClass.FindSongs;
import com.example.wyy.classes.TopClass.Top;
import com.example.wyy.classes.TopClass.Tops;
import com.example.wyy.main.select.SelectActivity2;
import com.example.wyy.string.Strings;
import com.example.wyy.util.HttpBack;
import com.example.wyy.util.HttpUtil;
import com.example.wyy.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class FindFragment extends Fragment {
    private FragmentManager manager;
    private FragmentTransaction ft;
    String address;
    Button button;
    DrawerLayout drawerLayout;
    RadioButton radioButton;//左边的
    RecyclerView recyclerView;//歌单
    RecyclerView recyclerView1;//banner轮播
    RecyclerView recyclerView2;//ball
    SwipeRefreshLayout swipeRefreshLayout;
    FindAdapterThree findAdapterThree;
    BannerAdapter bannerAdapter;
    BallAdapter ballAdapter;
    LinearLayoutManager linearLayoutManager;
    LinearLayoutManager linearLayoutManager1;
    LinearLayoutManager linearLayoutManager2;
    private List<FindSongs> findSongsList=new ArrayList<>();
    private List<FindSong> findSongList=new ArrayList<>();
    private List<Banners>bannersList=new ArrayList<>();
    private List<Banner> bannerList=new ArrayList<>();
    private List<Balls> ballsList=new ArrayList<>();
    private List<Ball> ballList=new ArrayList<>();
    RecyclerView recyclerView3;
    LinearLayoutManager linearLayoutManager3;
    TopsAdapter topAdapter;
    List<Top> topList=new ArrayList<>();
    List<Tops> topsList=new ArrayList<>();
    private static int y;
//    private static int count=0;
//
//    private RecyclerViewOnScrollListener.UpPullOnScrollListener onScrollListener=new RecyclerViewOnScrollListener.UpPullOnScrollListener() {
//        //上拉
//        @Override
//        public void onLoadMore() {
//        }
//        //下拉
//        @SuppressLint("ResourceAsColor")
//        @Override
//        public void onRefresh() {
//            count++;
//            swipeRefreshLayout.setEnabled(true);
//            //加颜色
//            swipeRefreshLayout.setColorSchemeColors(R.color.teal_700,R.color.teal_200);
//            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                @Override
//                public void onRefresh() {
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
////                            Log.d("RRRRRRRRRRRRRRRR","成功");
//                            ballList.clear();
//                            upRecycler();
//                            swipeRefreshLayout.setRefreshing(false);
//                            Toast.makeText(getContext(),"刷新成功！",Toast.LENGTH_SHORT).show();
//                        }
//                    },2000);
//                }
//            });
//
//        }
//    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View cow =inflater.inflate(R.layout.fragment_find, container, false);
        //显示左侧栏
        radioButton=cow.findViewById(R.id.find_radioButton_left);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //歌单类别
        recyclerView=cow.findViewById(R.id.find_recycle);
        linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        updataList();
        findAdapterThree=new FindAdapterThree(findSongList,getActivity());
        recyclerView.setAdapter(findAdapterThree);


        //Banner
//        swipeRefreshLayout=cow.findViewById(R.id.find_swipe_1);
        recyclerView1=cow.findViewById(R.id.find_recycle_1);
        //context有一点问题
//        recyclerView1.addOnScrollListener(new RecyclerViewOnScrollListener(onScrollListener));
        linearLayoutManager1=new LinearLayoutManager(cow.getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        y=linearLayoutManager1.findFirstVisibleItemPosition();
        recyclerView1.setLayoutManager(linearLayoutManager1);
        upRecycler();
        bannerAdapter=new BannerAdapter(bannerList);
        recyclerView1.setAdapter(bannerAdapter);
//        recyclerView1.setFocusableInTouchMode(false);
        //一页一页滑动
        PagerSnapHelper pagerSnapHelper=new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView1);
        //自动轮播
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Log.d("ssssssssssss",String.valueOf(y));
                y=y+1;
                if (y > 5) {
                    y = 0;
                }
                recyclerView1.smoothScrollToPosition(y);

            }
        },5000,5000, TimeUnit.MILLISECONDS);




        //ball
        recyclerView2=cow.findViewById(R.id.find_recycle_2);
        //context有一点问题
        linearLayoutManager2=new LinearLayoutManager(cow.getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        updataBall();
        ballAdapter=new BallAdapter(ballList);
        recyclerView2.setAdapter(ballAdapter);

       /* //测试fragment的转换
        Button button=cow.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                *//*HomeFragment homeFragme
                nt=new HomeFragment();
                manager=getFragmentManager();
                ft=manager.beginTransaction();
                ft.replace(R.layout.fragment_find,homeFragment);
                ft.addToBackStack(null);
                ft.commit();*//*
                Intent intent=new Intent(getContext(), SongActivity.class);
                startActivity(intent);
            }
        });*/
        button=cow.findViewById(R.id.find_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SelectActivity2.class);
                startActivity(intent);
            }
        });


        //排行
        recyclerView3=cow.findViewById(R.id.find_recycle3);
        linearLayoutManager3=new LinearLayoutManager(getContext());
        linearLayoutManager3.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        update();
        topAdapter=new TopsAdapter(topList);
        recyclerView3.setAdapter(topAdapter);

        return cow;
    }

    //排行
    private void update() {
        address = Strings.TOP;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("SSSSSSSSSSSS", "正在进行");
                topsList = new JsonUtil().JsonTop(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < topsList.size(); i++) {
                            Top sList = new Top(topsList.get(i).getName(), topsList.get(i).getCoverImgUrl(), topsList.get(i).getId(),topsList.get(i).getDescription());
                            Log.d("SELECTNAME", sList.getName());
                            topList.add(sList);
                        }
                        topAdapter.notifyDataSetChanged();
                        recyclerView3.setAdapter(topAdapter);
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("AAAAA", "请求失败");
            }
        });
    }
    //歌单
    private void updataList(){
        address= Strings.FIND_HY;
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

    //banner
    private void upRecycler(){
        address= Strings.FIND_BANNER;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("bbbbbb","正在进行");
                bannersList=new JsonUtil().JsonBanners(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < bannersList.size(); i++) {
                           Banner banner=new Banner(bannersList.get(i).getPic());
                            bannerList.add(banner);
                        }
                        bannerAdapter.notifyDataSetChanged();
                        recyclerView1.setAdapter(bannerAdapter);
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.d("LLLLLLLL","请求失败");
            }
        });
    }
    //ball
    private void updataBall(){
        address= Strings.FIND_BALL;
        new HttpUtil().sendHttpRequest(address, new HttpBack() {
            @Override
            public void onFinish(String response) {
                Log.d("babbbbb","正在进行");
                ballsList=new JsonUtil().JsonBalls(response);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < ballsList.size(); i++) {
                            Ball ball=new Ball(ballsList.get(i).getName(),ballsList.get(i).getIconUrl());
                            ballList.add(ball);
                        }
                        ballAdapter.notifyDataSetChanged();
                        recyclerView2.setAdapter(ballAdapter);
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