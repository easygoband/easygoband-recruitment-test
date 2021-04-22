package com.example.android.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.data.commons.BaseRepository
import com.example.android.data.commons.Constants
import com.example.android.data.local.EventDatabase
import com.example.android.data.local.EventDatabaseDao
import com.example.android.data.models.EventDTO
import com.example.android.data.remote.IEventsAPI
import com.example.android.data.remote.ResultHandler

class EventsRepository(
    private val api: IEventsAPI,
    private val eventDB: EventDatabase
): BaseRepository() {

    //API
    suspend fun getAndSaveEvents(id: Int): ResultHandler<String> {

        //Call to API and save in Room
        return when (val result = safeApiCall(call = { api.getEvents(Constants.API_BASIC_AUTH, id) })) {
            is ResultHandler.Success -> {

                result.data.let {eventList ->
                    //Save data in Room
                    eventDB.eventDatabaseDao().saveEvents(eventList)

                }
                ResultHandler.Success("Successful update")
            }
            is ResultHandler.GenericError -> result
            is ResultHandler.HttpError -> result
            is ResultHandler.NetworkError -> result
        }
    }

    suspend fun getEvents(): List<EventDTO> = eventDB.eventDatabaseDao().loadEventsList()

    suspend fun getEventsFilteredByName(str: String): List<EventDTO> = eventDB.eventDatabaseDao().loadEventsByName(str)

    suspend fun getEventsFilteredBySessionName(str: String): List<EventDTO> = eventDB.eventDatabaseDao().loadEventsBySessionName(str)

}