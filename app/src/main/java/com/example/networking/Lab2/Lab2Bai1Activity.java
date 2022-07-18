package com.example.networking.Lab2;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networking.MainActivity;
import com.example.networking.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab2Bai1Activity extends AppCompatActivity {
    public static final String SEVER_NAME = "http://172.20.10.9:8888/bai1";
    EditText edName,edScore;
    TextView tvResult;
    Button btnSend;
    String name,score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_bai1);
        edName = findViewById(R.id.edName);
        edScore = findViewById(R.id.edScore);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edName.getText().toString();
                score = edScore.getText().toString();
                BackgroundTask_GET backgroundTask_get = new BackgroundTask_GET(tvResult, name, score, getApplicationContext());
                backgroundTask_get.execute();
            }
        });

    }
}