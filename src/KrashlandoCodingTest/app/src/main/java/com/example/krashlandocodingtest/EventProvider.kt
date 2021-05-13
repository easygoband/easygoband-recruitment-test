package com.example.krashlandocodingtest

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class EventProvider(
        @SerializedName("access_group_name")
        val accessGroupName: String?,
        @SerializedName("access_group_id")
        val accesGroupId: Int = 0,
        @SerializedName("name")
        val name: String?,
        @SerializedName("modified")
        val modified: String?,
        @SerializedName("sessions")
        val sessions: Array<EventSession>?,
        @SerializedName("event_id")
        val eventId: Int,
        @SerializedName("total_uses")
        val totalUses: Int = 0,
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("structure_decode")
        val structureDecode: Boolean = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArray(EventSession),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(accessGroupName)
        parcel.writeInt(accesGroupId)
        parcel.writeString(name)
        parcel.writeString(modified)
        parcel.writeTypedArray(sessions, flags)
        parcel.writeInt(id)
        parcel.writeInt(totalUses)
        parcel.writeInt(id)
        parcel.writeByte(if (structureDecode) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventProvider> {
        override fun createFromParcel(parcel: Parcel): EventProvider {
            return EventProvider(parcel)
        }

        override fun newArray(size: Int): Array<EventProvider?> {
            return arrayOfNulls(size)
        }
    }
}