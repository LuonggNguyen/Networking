package com.example.networking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.networking.Lab1.Bai1Lab1Activity;
import com.example.networking.Lab1.Bai3Lab1Activity;
import com.example.networking.Lab1.Bai4Lab1Activity;
import com.example.networking.Lab1.SplashScreen;
import com.example.networking.R;

public class Lab1Activity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        btn1 = findViewById(R.id.btnBai1);
        btn2 = findViewById(R.id.btnBai2);
        btn3 = findViewById(R.id.btnBai3);
        btn4 = findViewById(R.id.btnBai4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Bai1Lab1Activity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, SplashScreen.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Bai3Lab1Activity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1Activity.this, Bai4Lab1Activity.class);
                startActivity(intent);
            }
        });
    }

}