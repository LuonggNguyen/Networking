package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.networking.Authentication.ProfileActivity;
import com.example.networking.Product.AddProductActivity;
import com.example.networking.Product.AllProductsActivity;

public class ProductActivity extends AppCompatActivity {

    private Button btnViewProducts;
    private Button btnAddProduct;
    private Button btnViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);

        btnViewProducts = findViewById(R.id.btnViewProducts);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        btnViewProfile = findViewById(R.id.btnViewProfile);

        btnViewProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this,
                        AllProductsActivity.class);
                startActivity(intent);
            }
        });
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this,
                        AddProductActivity.class);
                startActivity(intent);
            }
        });
        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductActivity.this,
                        ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}