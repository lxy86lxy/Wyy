package com.example.wyy.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.wyy.R;
import com.example.wyy.main.fragment.AttentionFragment;
import com.example.wyy.main.fragment.BoFragment;
import com.example.wyy.main.fragment.CloudFragment;
import com.example.wyy.main.fragment.FindFragment;
import com.example.wyy.main.fragment.MyFragment;
import com.example.wyy.main.left.N_7_Activity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setEnterTransition(new Explode().setDuration(2000));
        getWindow().setExitTransition(new Explode().setDuration(2000));
        ViewPager2 viewPager2=findViewById(R.id.first_viewpager2);
        ArrayList<Fragment>list=new ArrayList<>();
        list.add(new FindFragment());
        list.add(new BoFragment());
        list.add(new MyFragment());
        list.add(new AttentionFragment());
        list.add(new CloudFragment());
        BottomNavigationView bottomNavigationView=findViewById(R.id.First_bottom_navigation);
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
//        ImageButton imageButton=findViewById(R.id.navigation_button);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, SongActivity.class);
//                startActivity(intent);
//            }
//        });

        //导航侧栏
        NavigationView navigationView=findViewById(R.id.first_navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.N_7:
                        Intent intent =new Intent(MainActivity.this, N_7_Activity.class);
                        startActivity(intent);
                }
                return false;
            }
        });
    }
}