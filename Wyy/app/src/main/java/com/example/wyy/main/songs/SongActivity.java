package com.example.wyy.main.songs;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.wyy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        ViewPager2 viewPager2=findViewById(R.id.song_pager);
        ArrayList<androidx.fragment.app.Fragment> list=new ArrayList<>();
        list.add(new BlankFragment_HY());
        list.add(new BlankFragment_Lx());
        list.add(new BlankFragment_YG());
        list.add(new BlankFragment_MY());
        list.add(new BlankFragment_DZ());
        BottomNavigationView bottomNavigationView=findViewById(R.id.song_pager_bottom);
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public Fragment createFragment(int position) {
                return list.get(position);
            }

            @Override
            public int getItemCount() {
                return list.size();
            }
        });
        //注册改变时的回调
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                viewPager2.setCurrentItem(item.getOrder());
                return true;
            }
        });
    }
    }
