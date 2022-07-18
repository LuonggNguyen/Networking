package com.example.networking.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.networking.MainActivity;
import com.example.networking.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Lab3Bai4Activity extends AppCompatActivity {
    private ListView listView;
    private View parentView;
    private ArrayList<Contact1> contactList;
    private MyContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai4);
        contactList = new ArrayList<>();
        parentView = findViewById(R.id.parentLayout);
        listView = (ListView) findViewById(R.id.lsB4);
        listView.setOnItemClickListener(new
        AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                Snackbar.make(parentView,
                        contactList.get(position).getName() + " => " +
                                contactList.get(position).getPhone().getHome(),
                        Snackbar.LENGTH_LONG).show();
            }
        });
        FloatingActionButton fab = (FloatingActionButton)
                findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if
                (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    dialog = new ProgressDialog(Lab3Bai4Activity.this);
                    dialog.setTitle(":))");
                    dialog.setMessage("1.1.1.1");
                    dialog.show();
                    //Creating an object of our api interface
                    ApiService api = RetroClient.getApiService();
                    // Calling JSON
                    Call<ContactList> call = api.getMyJSON();
                    call.enqueue(new Callback<ContactList>() {
                        @Override
                        public void onResponse(Call<ContactList> call,
                                               Response<ContactList> response) {
                            //Dismiss Dialog
                            dialog.dismiss();
                            if(response.isSuccessful()) {
                                // Got Successfully
                                contactList = response.body().getContacts();
                                // Binding that List to Adapter
                                adapter = new
                                        MyContactAdapter(Lab3Bai4Activity.this, contactList);
                                listView.setAdapter(adapter);
                            } else {
                                Snackbar.make(parentView, "WRONG", Snackbar.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<ContactList> call,
                                              Throwable t) {
                            dialog.dismiss();
                        }
                    });
                } else {
                    Snackbar.make(parentView,
                            "Connettion",
                            Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}