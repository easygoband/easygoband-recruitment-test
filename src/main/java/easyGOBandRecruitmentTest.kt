import khttp.get
import org.json.JSONArray
import org.json.JSONObject

class GetData() {
    // Variables to get data from known url.
    private val provider: Providers = Providers()
    private val url : String = provider.getApiURL()
    private var defaultEventID: Int = provider.getApiEventID()
    private val APIkey: String = provider.getApiKey()
    private val headers: Map<String, String> = mapOf(
        "content-type" to "application/json",
        "Authorization" to "Basic $APIkey"
    )

    // Attributes
    private val nameList: MutableList<String> = mutableListOf()
    private val nameSet: MutableSet<String> = mutableSetOf()
    private val elements: MutableList<Element> = mutableListOf()

    // Methods
    private fun getURL(eventID: Int?): JSONArray {
        val response = get("$url${eventID ?: defaultEventID}", headers = headers)
        return response.jsonArray
    }

    fun getNames(): List<String> {
        return nameSet.sorted()
    }

    fun showSessionNames() {
        if (nameSet.size == 0) {
            println("No data were loaded.")
            return
        }
        for (key in getNames())
            println(key)
        println("\nThere are ${nameList.size} elements for ${nameSet.size} different session names.")
    }

    fun run(){
        val data = getURL(null)
        for (item in data) {
            val jsonObject = JSONObject(item.toString())
            val sessionArray = JSONArray(jsonObject.get("sessions").toString())
            if (sessionArray.length() != 1)
                throw Exception("UnsupportedSizeException") // cause: Array has got an unexpected length.
            val sessionItems = JSONObject(sessionArray[0].toString())
            val sessionName = sessionItems.get("name").toString()
            nameList.add(sessionName)
            nameSet.add(sessionName)
            val id: Int = jsonObject.get("id").toString().toInt()
            val name: String = jsonObject.get("name").toString()
            val accGroupName: String = jsonObject.get("access_group_name").toString()
            val accGroupId: Int = jsonObject.get("access_group_id").toString().toInt()
            val totalUses: Int = jsonObject.get("total_uses").toString().toInt()
            val eventID: Int = jsonObject.get("event_id").toString().toInt()
            val structureDecode: Boolean = jsonObject.get("structure_decode").toString().toLowerCase().toBoolean()
            val modified: String = jsonObject.get("modified").toString()
            val basicProductID: Int = jsonObject.get("basic_product_id").toString().toInt()
            val element = Element()
            element.setID(id)
            element.setName(name)
            element.setModified(modified)
            element.setSessionName(sessionName)
            element.setAccessGroupID(accGroupId)
            element.setAccessGroupName(accGroupName)
            element.setTotalUses(totalUses)
            element.setEventID(eventID)
            element.setStructureDecode(structureDecode)
            element.setBasicProductID(basicProductID)

            elements.add(element)
        }
    }

    fun showDataFromSessionName(sessionName: String) {
        var shown = 0
        for (element in elements)
            if (element.getSessionName() == sessionName) {
                println("${++shown}.-")
                element.show()
            }

        if (shown < 1) {
            println("Session name must be one of the following names:")
            showSessionNames()
        }
    }

    fun showData() {
        var shown = 0
        for (element in elements) {
            println("${++shown}.- ")
            element.show()
        }
    }
}

fun main(args: Array<String>) {
    val data = GetData()
    data.run()
    when (args[0]) {
        "--all" -> data.showData()
        "--filter" -> data.showDataFromSessionName(args[1])
        "--names" -> data.showSessionNames()
        else -> println("Try one of this options:\n\t--all\n\t--filter <session name>\n\t--names")
    }
}

