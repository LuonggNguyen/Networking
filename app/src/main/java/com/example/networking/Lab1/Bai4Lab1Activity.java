package com.example.networking.Lab1;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networking.R;

public class Bai4Lab1Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edTime;
    private Button btnRun;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_lab1);

        edTime = findViewById(R.id.edTime);
        btnRun = findViewById(R.id.runAsync);
        tvResult = findViewById(R.id.tvResult);
        btnRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.runAsync:
                AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(tvResult,edTime,this);
                String sleeptime = edTime.getText().toString();
                asyncTaskRunner.execute(sleeptime);
                break;
        }
    }
}