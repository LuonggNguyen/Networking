package com.example.networking.Lab3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RequestInterface {
    @GET("adr")
    @Headers("Content-Type: application/json")
    Call<JSONResponse> getJSON();
}
