package com.example.krashlandocodingtest

import android.os.Parcel
import android.os.Parcelable

data class EventSession(
        val name: String?,
        val id: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EventSession> {
        override fun createFromParcel(parcel: Parcel): EventSession {
            return EventSession(parcel)
        }

        override fun newArray(size: Int): Array<EventSession?> {
            return arrayOfNulls(size)
        }
    }
}