package com.reflectwaresoftwares.cpncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    final private int SPLASH_SCREEN_TIMEOUT= 4000;
    private ImageView logoImage;
    private Animation animation;
    private TextView title;
    private Animation bottomAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logoImage=(ImageView) findViewById(R.id.logo_image);
        animation=(Animation) AnimationUtils.loadAnimation(this,R.anim.anim_top);
        logoImage.setAnimation(animation);
        bottomAnimation=(Animation) AnimationUtils.loadAnimation(this,R.anim.anim_bottom);
        title=(TextView) findViewById(R.id.logo_text_title);
        title.setAnimation(bottomAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent splash=new Intent(Splash.this,MainActivity.class);
              startActivity(splash);
              finish();

            }
        },SPLASH_SCREEN_TIMEOUT);
    }
}
