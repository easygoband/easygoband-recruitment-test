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
    private var jsonKeys: Set<String> = setOf()
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
        val jsonData = data.getJSONObject(0)
        jsonKeys = jsonData.keySet()
        for (item in data) {
            val jsonObject = JSONObject(item.toString())
            val sessionArray = JSONArray(jsonObject.get("sessions").toString())
            if (sessionArray.length() != 1)
                throw Exception("UnsupportedSizeException") // cause: Array has got an unexpected length.
            val sessionItems = JSONObject(sessionArray[0].toString())
            val sessionName = sessionItems.getString("name")
            nameList.add(sessionName)
            nameSet.add(sessionName)
            val element = Element()
            element.setID(jsonObject.getInt("id"))
            element.setName(jsonObject.getString("name"))
            element.setModified(jsonObject.getString("modified"))
            element.setSessionName(sessionName)
            element.setAccessGroupID(jsonObject.getInt("access_group_id"))
            element.setAccessGroupName(jsonObject.getString("access_group_name"))
            element.setTotalUses(jsonObject.getInt("total_uses"))
            element.setEventID(jsonObject.getInt("event_id"))
            element.setStructureDecode(jsonObject.getBoolean("structure_decode"))
            element.setBasicProductID(jsonObject.getInt("basic_product_id"))

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

