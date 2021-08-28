package com.example.wyy.main.start;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.wyy.R;
import com.example.wyy.main.MainActivity;
import com.example.wyy.main.music.Music_Activity;
import com.google.android.material.chip.Chip;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Chip chip=findViewById(R.id.chip4);
        chip.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StartActivity.this, MainActivity.class);

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(StartActivity.this).toBundle());
            }
        });
    }
}