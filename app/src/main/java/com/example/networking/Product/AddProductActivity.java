package com.example.networking.Product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.networking.R;

public class AddProductActivity extends AppCompatActivity {

    private EditText edtName,edtImg, edtPrice, edtDescription;
    private Button btnAdd;
    String strName,strImg,strPrice,strDes;
    CreateNewProducTask newProductTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        edtName = (EditText)findViewById(R.id.edtProductNameAdd);
        edtImg = (EditText)findViewById(R.id.edtImgAdd);
        edtPrice = (EditText)findViewById(R.id.edtProductPriceAdd);
        edtDescription = (EditText)findViewById(R.id.edtProductDesAdd);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        newProductTask = new CreateNewProducTask(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strName = edtName.getText().toString();
                strImg = edtImg.getText().toString();
                strPrice = edtPrice.getText().toString();
                strDes = edtDescription.getText().toString();
                newProductTask.execute(strName,strImg,strPrice,strDes);
            }
        });
    }
}