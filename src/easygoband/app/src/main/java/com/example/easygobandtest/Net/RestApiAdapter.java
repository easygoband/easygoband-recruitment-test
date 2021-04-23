package com.example.easygobandtest.Net;

import com.example.easygobandtest.Net.ApiService;
import com.example.easygobandtest.Net.ProveedoresDeserializador;
import com.example.easygobandtest.Net.ProveedoresResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public ApiService establecerConexionApiRest(Gson gson){

        final String basic="Basic cJmAc71jah17sgqi1jqaksvaksda=";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Authorization", basic);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }

        });

        OkHttpClient client = httpClient.build();


        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ApiService.class);
    }

    public Gson convierteGsonDeserializadorProveedores() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ProveedoresResponse.class, new ProveedoresDeserializador());

        return gsonBuilder.create();
    }


}
