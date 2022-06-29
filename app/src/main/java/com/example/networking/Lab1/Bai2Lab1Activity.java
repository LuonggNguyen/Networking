package com.example.networking.Lab1;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networking.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Bai2Lab1Activity extends AppCompatActivity {

    private Button btnLoad;
    private ImageView img;
    private TextView tvMsg;
    private ProgressDialog progressDialog;
    private String url = "https://img.icons8.com/clouds/344/android-os.png";
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lab1);
        btnLoad = findViewById(R.id.btnLoad);
        img = findViewById(R.id.imageView);
        tvMsg = findViewById(R.id.tvMess);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = ProgressDialog.show(Bai2Lab1Activity.this,"","Downloading...!");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        bitmap = downBitmap(url);
                        Message msg = msgHandler.obtainMessage();
                        Bundle bundle = new Bundle();
                        String threadMsg = "Img downloader";
                        bundle.putString("Msg",threadMsg);
                        msg.setData(bundle);
                        msgHandler.sendMessage(msg);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
            }
        });

    }

    private Bitmap downBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            Log.d(">>>>>", "downBitmap: "+bitmap);
            return bitmap;
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Handler msgHandler = new Handler() {
        public  void handleMessage (Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String mess = bundle.getString("Message","Successfull!!");
            tvMsg.setText(mess);
            Log.d("111", "handleMessage: "+mess);
            img.setImageBitmap(bitmap);
            progressDialog.dismiss();

        }
    };
}