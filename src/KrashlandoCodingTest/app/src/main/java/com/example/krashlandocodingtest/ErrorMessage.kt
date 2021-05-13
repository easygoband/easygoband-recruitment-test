package com.example.krashlandocodingtest

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class ErrorMessage(
        @SerializedName("message")
        val message: String?
) : Parcelable {
    constructor(parcel: Parcel): this (
            parcel.readString()
            ) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ErrorMessage> {
        override fun createFromParcel(parcel: Parcel): ErrorMessage {
            return ErrorMessage(parcel)
        }

        override fun newArray(size: Int): Array<ErrorMessage?> {
            return arrayOfNulls(size)
        }
    }
}