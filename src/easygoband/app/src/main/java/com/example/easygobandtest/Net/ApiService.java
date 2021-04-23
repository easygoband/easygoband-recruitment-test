package com.example.easygobandtest.Net;

import com.example.easygobandtest.Net.ProveedoresResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("dev/providers/{eventId}")

    public Call<ProveedoresResponse> find(@Path("eventId") String eventId);

}
