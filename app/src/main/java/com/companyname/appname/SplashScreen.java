package com.companyname.appname;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    Animation Splash_top, Splash_bottom;
    ImageView splash_logo;
    TextView splash_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Change the status bar color
        getWindow().setStatusBarColor(getResources().getColor(R.color.statusBarColor));

        setContentView(R.layout.activity_splash_screen);

        splash_logo = findViewById(R.id.splash_logo);
        splash_name = findViewById(R.id.splash_name);

        Splash_top = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        Splash_bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        splash_logo.setAnimation(Splash_top);
        splash_name.setAnimation(Splash_bottom);

        // For Splash Screen delay
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        }, 3000); // 3-second delay
    }
}
