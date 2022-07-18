package com.example.networking.Lab1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networking.R;

import java.net.URL;

public class Bai3Lab1Activity extends AppCompatActivity implements View.OnClickListener,Listener {

    private Button btnLoad;
    private ImageView img;
    private TextView msg;

    public static final String IMG_URL = "https://img.icons8.com/clouds/344/android-os.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3_lab1);
        btnLoad = findViewById(R.id.btnLoad);
        img = findViewById(R.id.imageView);
        msg = findViewById(R.id.tvMess);

        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLoad:
                new LoadImageTask(this,this).execute(IMG_URL);
                break;
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
        msg.setText("Image Downloaded");
    }

    @Override
    public void onError() {
        msg.setText("Error !!");
    }


}