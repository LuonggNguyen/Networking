package com.example.networking.Lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networking.R;

public class Lab2Bai2Activity extends AppCompatActivity {
    public static final String SEVER_NAME = "http://192.168.1.5:8888/bai2";
    EditText edDai,edRong;
    TextView tvResult;
    Button btnSend;
    String dai,rong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_bai2);
        edDai = findViewById(R.id.edDai);
        edRong = findViewById(R.id.edRong);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dai = edDai.getText().toString();
                rong = edRong.getText().toString();
                BackgroundTask_POST backgroundTask_post = new BackgroundTask_POST(tvResult, dai, rong, getApplicationContext());
                backgroundTask_post.execute();
            }
        });

    }
}