package com.example.networking.Lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networking.R;

public class Lab2Bai3Activity extends AppCompatActivity {
    public static final String SEVER_NAME = "http://172.20.10.98888/bai3";
    EditText edCanh;
    TextView tvResult;
    Button btnSend;
    String canh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_bai3);
        edCanh = findViewById(R.id.edCanh);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canh = edCanh.getText().toString();
                BackgroundTask_POST1 backgroundTask_post1 = new BackgroundTask_POST1(tvResult, canh, getApplicationContext());
                backgroundTask_post1.execute();
            }
        });

    }
}