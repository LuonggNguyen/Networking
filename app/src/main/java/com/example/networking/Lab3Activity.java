package com.example.networking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networking.Lab2.Lab2Bai1Activity;
import com.example.networking.Lab3.Lab3Bai1Activity;
import com.example.networking.Lab3.Lab3Bai2Activity;
import com.example.networking.Lab3.Lab3Bai3Activity;
import com.example.networking.Lab3.Lab3Bai4Activity;


public class Lab3Activity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        btn1 = findViewById(R.id.btnBai1);
        btn2 = findViewById(R.id.btnBai2);
        btn3 = findViewById(R.id.btnBai3);
        btn4 = findViewById(R.id.btnBai4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, Lab3Bai1Activity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, Lab3Bai2Activity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, Lab3Bai3Activity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3Activity.this, Lab3Bai4Activity.class);
                startActivity(intent);
            }
        });
    }
}