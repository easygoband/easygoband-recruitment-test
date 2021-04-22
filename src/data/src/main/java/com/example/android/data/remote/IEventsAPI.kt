package com.example.android.data.remote

import com.example.android.data.models.EventDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface IEventsAPI {

    //get List of events with given ID with encrypted Basic Authorization
    @GET("dev/providers/{eventId}")
    suspend fun getEvents(
        @Header("Authorization") basicAut: String,
        @Path("eventId") eventId: Int
    ): Response<List<EventDTO>>
}