package com.example.networking.Lab3;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networking.R;

public class Lab3Bai1Activity extends AppCompatActivity {

    ListView lvContact;
    GetContact getContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai1);
        lvContact = findViewById(R.id.listContact);
        getContact = new GetContact(this,lvContact);
        getContact.execute();
    }
}