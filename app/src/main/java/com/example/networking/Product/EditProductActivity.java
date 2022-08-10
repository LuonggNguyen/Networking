package com.example.networking.Product;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.networking.R;
import com.squareup.picasso.Picasso;

public class EditProductActivity extends AppCompatActivity {

    private EditText edtName, edtPrice, edtDes,edtImg;
    private Button btnSave, btnDelete;
    ImageView imgProduct;
    String pid, strName, strPrice, strDes,strImg;
    GetProducDetailsTask productDetailsTask;
    SaveProductDetailsTask saveProductDetailsTask;
    DeleteProductTask deleteProductTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);
        imgProduct = findViewById(R.id.imgProduct);
        edtName = (EditText) findViewById(R.id.edtProductName);
        edtImg = (EditText) findViewById(R.id.edtImg);
        edtPrice = (EditText) findViewById(R.id.edtProductPrice);
        edtDes = (EditText) findViewById(R.id.edtProductDes);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        pid = getIntent().getStringExtra(Constants.TAG_PID);
        Log.e("//", "=="+pid );
        Picasso.get().load(edtImg.toString()).into(imgProduct);
        productDetailsTask = new GetProducDetailsTask(this,edtName,edtImg,edtPrice,edtDes);
        productDetailsTask.execute(pid);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strName = edtName.getText().toString();
                strImg = edtImg.getText().toString();
                strPrice = edtPrice.getText().toString();
                strDes = edtDes.getText().toString();
                saveProductDetailsTask = new SaveProductDetailsTask(EditProductActivity.this);
                saveProductDetailsTask.execute(pid,strName,strImg,strPrice,strDes);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProductTask = new DeleteProductTask(EditProductActivity.this);
                AlertDialog.Builder builder = new AlertDialog.Builder(EditProductActivity.this);
                builder.setTitle("Deleting product...");
                builder.setMessage("Are you sure you want delete this product?");
                        builder.setNegativeButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        deleteProductTask.execute(pid);
                                        dialogInterface.dismiss();
                                        Toast.makeText(EditProductActivity.this,"Deleted",Toast.LENGTH_LONG).show();
                                    }
                                });
                builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                builder.show();
            }
        });
    }
}