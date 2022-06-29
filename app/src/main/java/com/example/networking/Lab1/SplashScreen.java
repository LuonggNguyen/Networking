package com.example.networking.Lab1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.networking.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPALSH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,Bai2Lab1Activity.class);
                startActivity(intent);
                finish();
            }
        }, SPALSH_TIME_OUT);
    }
}