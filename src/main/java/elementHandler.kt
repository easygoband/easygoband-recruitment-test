import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

public class ElementHandler (private val jsonArray: JSONArray) {
    private val knownKeys : List<String> = listOf(
        "access_group_name", "access_group_id", "total_uses", "sessions", "event_id",
        "structure_decode", "name", "modified", "id", "basic_product_id"
    )

    fun check() {
        /*
            access_group_name, access_group_id, total_uses, sessions, event_id,
            structure_decode, name, modified, id, basic_product_id
        */
        for (i in 0 until jsonArray.length()) {
            val givenKeys = jsonArray.getJSONObject(i).keySet()
            for (key in givenKeys) {
                if (key !in knownKeys)
                    throw JSONException("Attribute $key unknown.")
            }
        }
    }

    fun handle(): List<Element> {
        val elements: MutableList<Element> = mutableListOf()
        for (item in jsonArray) {
            val jsonObject = JSONObject(item.toString())
            val givenKeys = jsonObject.keySet()
            val element = Element()
            givenKeys.forEach {
                when (it) {
                    null -> throw JSONException("Attribute was null")
                    "id" -> element.setID(jsonObject.getInt("id"))
                    "name" -> element.setName(jsonObject.getString("name"))
                    "modified" -> element.setModified(jsonObject.getString("modified"))
                    "access_group_id" -> element.setAccessGroupID(jsonObject.getInt("access_group_id"))
                    "access_group_name" -> element.setAccessGroupName(jsonObject.getString("access_group_name"))
                    "total_uses" -> element.setTotalUses(jsonObject.getInt("total_uses"))
                    "event_id" -> element.setEventID(jsonObject.getInt("event_id"))
                    "structure_decode" -> element.setStructureDecode(jsonObject.getBoolean("structure_decode"))
                    "basic_product_id" -> element.setBasicProductID(jsonObject.getInt("basic_product_id"))
                    "sessions" -> jsonObject.getJSONArray("sessions").forEach{
                        val innerJsonObject: JSONObject = it as JSONObject
                        val session = Session()
                        session.setID(innerJsonObject.getInt("id"))
                        session.setName(innerJsonObject.getString("name"))
                        element.addSession(session)
                    }
                    else -> throw JSONException("Attribute $it unknown.")
                }
            }
            elements.add(element)
        }
        return elements
    }
}