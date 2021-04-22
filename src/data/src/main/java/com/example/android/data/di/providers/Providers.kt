package com.example.android.data.di.providers

import android.app.Application
import com.example.android.data.BuildConfig
import com.example.android.data.commons.Constants
import com.example.android.data.local.EventDatabase
import com.example.android.data.remote.IEventsAPI
import com.example.android.data.repositories.EventsRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//Functions that return objects to provide the DI

fun provideOkHttpClient(): OkHttpClient {
    val client = OkHttpClient().newBuilder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        return client.build()
}


fun provideGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .serializeNulls()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .create()
}


fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
    .client(httpClient)
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()


fun provideEventsApi(retrofit: Retrofit): IEventsAPI = retrofit
    .create(IEventsAPI::class.java)

fun provideEventDatabase(application: Application): EventDatabase {
    return EventDatabase.getInstance(application)
}

fun provideEventsRepository(retrofit: IEventsAPI, eventDB: EventDatabase): EventsRepository = EventsRepository(retrofit, eventDB)