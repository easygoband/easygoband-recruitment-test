package com.example.android.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.android.data.commons.Constants
import com.example.android.data.utils.EventSessionConverter
import com.google.gson.annotations.SerializedName

//Json and Room object
@Entity(tableName = Constants.TABLE_EVENT)
data class EventDTO (
    @SerializedName("access_group_name")
    val accessGroupName: String,
    @SerializedName("access_group_id")
    val accessGroupId: Int,
    @SerializedName("total_users")
    val totalUses: Int,
    //transforms List into string with given class and vice versa
    @TypeConverters(EventSessionConverter::class)
    val sessions: List<EventType>,
    @SerializedName("event_id")
    val eventId: Int,
    @SerializedName("structure_decode")
    val structureDecode: Boolean,
    val name: String,
    val modified: String,
    @PrimaryKey
    val id: Int,
    @SerializedName("basic_product_id")
    val basicProductId: Int
    )

data class EventType(
    val name: String,
    val id: Int
)