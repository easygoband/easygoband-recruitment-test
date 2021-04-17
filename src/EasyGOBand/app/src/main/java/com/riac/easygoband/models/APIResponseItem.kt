package com.riac.easygoband.models

import java.io.Serializable

data class APIResponseItem(
    val access_group_id: Int,
    val access_group_name: String,
    val basic_product_id: Int,
    val event_id: Int,
    val id: Int,
    val modified: String,
    val name: String,
    val sessions: List<Session>,
    val structure_decode: Boolean,
    val total_uses: Int
) : Serializable {
    override fun toString(): String {
        return "ID: $id  \n" +
                "Name: $name  \n" +
                "Modified: $modified  \n" +
                "Sessions: ${sessions.size}"
    }

    fun allFormattedData(): String {
        return "ID: $id  \n" +
                "Name: $name  \n" +
                "Modified: $modified  \n" +
                "Access Group ID: $access_group_id \n" +
                "Access Group Name: $access_group_name \n" +
                "Basic Product ID: $basic_product_id \n" +
                "Event ID: $event_id \n" +
                "Total uses: $total_uses"
    }
}