package com.example.music_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView splashImageView;
    private static  int splashTimeout=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashImageView=(ImageView)findViewById(R.id.image_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(MainActivity.this,Music_Screen.class);
                startActivity(in);
                finish();
            }
        },splashTimeout);

        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.splash_screen);
        splashImageView.startAnimation(myanim);
    }
}
