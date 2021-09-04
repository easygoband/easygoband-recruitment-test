package model

import com.google.gson.annotations.SerializedName

/**
 * Data class with the information of an access entry.
 */
data class Access(
    @SerializedName("access_group_name") val accessGroupName: String,
    @SerializedName("access_group_id") val accessGroupID: Int,
    @SerializedName("total_uses") val totalUses: Int,
    @SerializedName("sessions") val sessions: List<Session>,
    @SerializedName("event_id") val eventID: Int,
    @SerializedName("stucture_decode") val structureDecode: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("id") val id: Int,
    @SerializedName("basic_product_id") val basicProductID: Int
) {
    //override fun toString(): String = accessGroupName
}

/**
 * Data class with the information of a session entry.
 */
data class Session(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int
)