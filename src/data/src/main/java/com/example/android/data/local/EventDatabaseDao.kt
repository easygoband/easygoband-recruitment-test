package com.example.android.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.data.commons.Constants
import com.example.android.data.models.EventDTO

@Dao
interface EventDatabaseDao{

    //insert event list
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEvents(eventList: List<EventDTO>)

    //get all events
    @Query("SELECT * FROM `${Constants.TABLE_EVENT}`")
    fun loadEventsList(): List<EventDTO>

    /**
     * Returns list of events filtered by name
     * str: no case sensitive
     */
    @Query("SELECT * FROM `${Constants.TABLE_EVENT}` WHERE name LIKE :str")
    fun loadEventsByName(str: String): List<EventDTO>

    @Query("SELECT * FROM `${Constants.TABLE_EVENT}` WHERE sessions LIKE :str")
    fun loadEventsBySessionName(str: String): List<EventDTO>




}
