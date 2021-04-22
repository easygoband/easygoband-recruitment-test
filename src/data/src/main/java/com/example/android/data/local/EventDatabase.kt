package com.example.android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.data.commons.Constants
import com.example.android.data.models.EventDTO
import com.example.android.data.utils.EventSessionConverter

@Database(entities = [EventDTO::class], version = 1)
@TypeConverters(EventSessionConverter::class)
abstract class EventDatabase : RoomDatabase() {

    //call when accessing database
    abstract fun eventDatabaseDao(): EventDatabaseDao

    //database creation
    companion object {
        @Volatile
        private var INSTANCE: EventDatabase? = null

        fun getInstance(context: Context): EventDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context.applicationContext).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(appContext: Context): EventDatabase {
            return Room.databaseBuilder(appContext, EventDatabase::class.java,
                Constants.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}