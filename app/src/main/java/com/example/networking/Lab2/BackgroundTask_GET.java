package com.example.networking.Lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundTask_GET extends AsyncTask<Void,Void,Void> {
    String link = Lab2Bai1Activity.SEVER_NAME;
    TextView tvResult;
    String name,score;
    String str;
    ProgressDialog progressDialog;
    Context context;
    public BackgroundTask_GET(TextView tvResult, String name, String score, Context context) {
        this.tvResult = tvResult;
        this.name = name;
        this.score = score;
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(tvResult.getContext());
        progressDialog.setMessage("Sending...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        link += "?name=" + this.name + "&score=" + this.score;
        try {
            URL url = new URL(link);
            Log.d("url",url.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line ="";
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            str = stringBuffer.toString();
            urlConnection.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(str);
    }
}
