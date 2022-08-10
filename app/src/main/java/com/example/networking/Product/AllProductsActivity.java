package com.example.networking.Product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.networking.ProductActivity;
import com.example.networking.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AllProductsActivity extends AppCompatActivity {

    private ListView lvProducts;
    FloatingActionButton fab;
    loadAllProducts task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        lvProducts = (ListView)findViewById(R.id.listProducts);
        fab = findViewById(R.id.fabAdd);
        task = new loadAllProducts(AllProductsActivity.this,lvProducts);
        task.execute();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllProductsActivity.this,
                        AddProductActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 100){
            // if result code 100 is received
            // means user edited/deleted product
            // reload this screen again
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

}