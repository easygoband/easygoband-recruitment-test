package dataclasses

import org.json.JSONException
import org.json.JSONObject
import utils.parseDateToEpoch

/**
 * Created by Albert Sendros on 15/6/18. Project -> test-easygoband Package dataclasses
 */
data class MyData(var accessGroupName: String = "", var accessGroupId: Int = 0, var totalUses: Int = 0, var sessions: List<MySession> = mutableListOf(),
                  var eventId: Int = 0, var structureDecode: Boolean = false, var name: String = "", var modified: Long = 0L, var id: Int = 0,
                  var basicProductId: Int = 0)

data class MySession(val name: String, val id: Int)

fun JSONObject.setMyDataAttribute(attribute: String, myData: MyData) {

    when (attribute) {
        "access_group_name" -> myData.accessGroupName = this.getString("access_group_name")
        "access_group_id" -> myData.accessGroupId = this.getInt("access_group_id")
        "total_uses" -> myData.totalUses = this.getInt("total_uses")
        "sessions" -> {
            val sessionsList = mutableListOf<MySession>()
            this.getJSONArray("sessions").forEach {
                val itJson = it as JSONObject
                val mySession = MySession(itJson.getString("name"), itJson.getInt("id"))
                sessionsList.add(mySession)
            }
            myData.sessions = sessionsList
        }
        "event_id" -> myData.eventId = this.getInt("event_id")
        "structure_decode" -> myData.structureDecode = this.getBoolean("structure_decode")
        "name" -> myData.name = this.getString("name")
        "modified" -> myData.modified = parseDateToEpoch(this.getString("modified"))
        "id" -> myData.id = this.getInt("id")
        "basic_product_id" -> myData.basicProductId = this.getInt("basic_product_id")
        else -> throw JSONException("Attribute $attribute not recognized")
    }
}

fun parseJsonToMyData(jsonObject: JSONObject): MyData {
    val listOfAttributes = listOf("access_group_name", "access_group_id", "total_uses", "sessions", "event_id",
            "structure_decode", "name", "modified", "id", "basic_product_id")
    val myData = MyData()
    listOfAttributes.forEach { jsonObject.setMyDataAttribute(it, myData) }
    return myData
}