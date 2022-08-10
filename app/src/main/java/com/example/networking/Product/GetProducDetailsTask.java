package com.example.networking.Product;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetProducDetailsTask extends AsyncTask<String, String , String> {
    Context context;
    ProgressDialog pDialog;
    JSONParser jsonParser;
    EditText edtName, edtImg, edtPrice, edtDes;
    Product product;
    public GetProducDetailsTask(Context context, EditText edtName,EditText edtImg,
                                EditText edtPrice, EditText edtDes){
        this.context = context;
        this.edtName = edtName;
        this.edtImg = edtImg;
        this.edtPrice = edtPrice;
        this.edtDes = edtDes;
        jsonParser = new JSONParser();
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading Product Details. Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
    }
    @Override
    protected String doInBackground(String... strings) {
        // Building Parameters
        List<HashMap<String, String>> params = new ArrayList<>();
        HashMap<String, String> hsPid = new HashMap<>();
        hsPid.put(Constants.TAG_PID,strings[0]);
        params.add(hsPid);
        try {
            // getting product details by Making HTTP request
            // Note that product details url will use GET request
            JSONObject json =
                    jsonParser.makeHttpRequest(Constants.url_product_detail,"GET",params);
            // json success tag
            int success = json.getInt(Constants.TAG_SUCCESS);
            if(success == 1){
                // successfelly received product details
                JSONArray productObj =
                        json.getJSONArray(Constants.TAG_PRODUCT);
                // get first product object from JSON Array
                JSONObject obj = productObj.getJSONObject(0);
                // product with this pid found
                product = new Product();
                product.setName(obj.getString(Constants.TAG_NAME));
                product.setImg(obj.getString(Constants.TAG_IMG));
                product.setPrice(obj.getString(Constants.TAG_PRICE));

                product.setDescription(obj.getString(Constants.TAG_DESCRIPTION));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
        edtName.setText(product.getName());
        edtImg.setText(product.getImg());
        edtPrice.setText(product.getPrice());
        edtDes.setText(product.getDescription());
    }
}
