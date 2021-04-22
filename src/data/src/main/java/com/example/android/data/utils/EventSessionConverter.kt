package com.example.android.data.utils

import androidx.room.TypeConverter
import com.example.android.data.models.EventType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EventSessionConverter {
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<EventType?>? {
        if (data == null) {
            return emptyList()
        }
        val listType = object : TypeToken<List<EventType?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<EventType?>?): String? {
        return Gson().toJson(someObjects)
    }
}