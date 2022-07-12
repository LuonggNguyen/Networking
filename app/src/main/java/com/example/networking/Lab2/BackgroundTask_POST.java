package com.example.networking.Lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask_POST extends AsyncTask<Void,Void,Void> {
    String link = Lab2Bai2Activity.SEVER_NAME;
    TextView tvResult;
    String index,index2;
    String str;
    ProgressDialog progressDialog;
    Context context;
    public BackgroundTask_POST(TextView tvResult, String index, String index2, Context context) {
        this.tvResult = tvResult;
        this.index = index;
        this.index2 = index2;
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
        link += "?a=" + this.index + "&b=" + this.index2;
        try {
            URL url = new URL(link);
            String param = "a=" + URLEncoder.encode(index,"utf-8") + "b=" + URLEncoder.encode(index2,"utf-8");
            Log.d("//", param);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            Log.d("==",urlConnection.toString());

            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

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
