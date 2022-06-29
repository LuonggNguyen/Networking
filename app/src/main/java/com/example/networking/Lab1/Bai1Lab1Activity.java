package com.example.networking.Lab1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networking.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai1Lab1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLoad;
    private ImageView img;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_lab1);
        btnLoad = findViewById(R.id.btnLoad);
        img = findViewById(R.id.imageView);
        msg = findViewById(R.id.tvMess);
    }

    private Bitmap loadImgFromNetwork (String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    public void onClick(View view) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final  Bitmap bitmap = loadImgFromNetwork("https://img.icons8.com/clouds/344/android-os.png");
                img.post(new Runnable() {
                    @Override
                    public void run() {
                        msg.setText("Image Downloaded");
                        Log.d( "/////","bitmat:"+bitmap);
                        img.setImageBitmap(bitmap);
                    }
                });
            }
        });
        thread.start();
    }
}