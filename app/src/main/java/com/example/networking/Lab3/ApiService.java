package com.example.networking.Lab3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/data")
    Call<ContactList> getMyJSON();
}
