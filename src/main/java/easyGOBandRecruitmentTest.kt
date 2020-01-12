import khttp.get
import org.json.JSONArray

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
        println("\nThere are ${elements.size} elements for ${nameSet.size} different session names.")
    }

    fun run(){
        val data = getURL(null)
        elements.addAll(ElementHandler(data).handle())
        val list = ElementHandler(data)
        list.check()
        elements.forEach{
            nameSet.add(it.getSessionNames())
        }
    }

    fun showDataFromSessionName(sessionName: String) {
        var shown = 0
        for (element in elements)
            if (element.hasSessionName(sessionName)) {
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

