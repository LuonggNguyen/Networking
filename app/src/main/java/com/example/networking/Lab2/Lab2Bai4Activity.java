package com.example.networking.Lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networking.R;

public class Lab2Bai4Activity extends AppCompatActivity {
    public static final String SEVER_NAME = "http://192.168.1.5:8888/bai4";
    EditText edA,edB,edC;
    TextView tvResult;
    Button btnSend;
    String a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_bai4);
        edA = findViewById(R.id.edA);
        edB = findViewById(R.id.edB);
        edC = findViewById(R.id.edC);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = edA.getText().toString();
                b = edB.getText().toString();
                c = edC.getText().toString();
                BackgroundTask_POST2 backgroundTask_post2 = new BackgroundTask_POST2(tvResult, a, b, c, getApplicationContext());
                backgroundTask_post2.execute();
            }
        });
    }
}