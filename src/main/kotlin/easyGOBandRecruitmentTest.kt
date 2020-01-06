import khttp.get
import org.json.JSONArray
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Element() {
    /*
    Fields returned by REST API:
        access_group_name, access_group_id, total_uses, sessions, event_id,
        structure_decode, name, modified, id, basic_product_id
     */
    private var id: Int = 0
    private var name: String = ""
    private var modified: LocalDateTime = LocalDateTime.now()
    private var sessionName: String = ""
    private var accessGroupID: Int = 0
    private var accessGroupName: String = ""
    private var totalUses: Int = 0
    private var eventID: Int = 0
    private var structureDecode: Boolean = false
    private var basicProductID: Int = 0

    fun setID(id: Int) {
        this.id = id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setModified(modified: String) {
        this.modified = LocalDateTime.parse(modified, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
    }

    fun setSessionName(sessionName: String){
        this.sessionName = sessionName
    }
    fun setAccessGroupID(accessGroupID: Int) {
        this.accessGroupID = accessGroupID
    }

    fun setAccessGroupName(accessGroupName: String) {
        this.accessGroupName = accessGroupName
    }

    fun setTotalUses(totalUses: Int){
        this.totalUses = totalUses
    }

    fun setEventID(eventID: Int){
        this.eventID = eventID
    }

    fun setStructureDecode(structureDecode: Boolean){
        this.structureDecode = structureDecode
    }

    fun setBasicProductID(basicProductID: Int) {
        this.basicProductID = basicProductID
    }

    fun getName(): String {
        return name
    }

    fun getSessionName(): String {
     return sessionName
    }

    fun getModified(): String {
        return modified.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }

    fun show() {
        println("\tID: $id\n\tNAME: $name\n\tACCESS GROUP NAME: $accessGroupName\n\tTOTAL USES: $totalUses")
        println("\tEVENT ID: $eventID\n\tBASIC PROD. ID: $basicProductID\n\tSTRUCTURE DECODE: $structureDecode")
        println("\tMODIFIED: ${getModified()}")
    }
}

class GetData() {
    // Variables to get data from known url.
    private val url: String = "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/"
    private var defaultID: Int = 1
    private val headers: Map<String, String> = mapOf(
        "content-type" to "application/json",
        "Authorization" to "Basic cJmAc71jah17sgqi1jqaksvaksda="
    )

    // Attributes
    private val nameList: MutableList<String> = mutableListOf()
    private val nameSet: MutableSet<String> = mutableSetOf()
    private val elements: MutableList<Element> = mutableListOf()

    // Methods
    private fun getURL(newIDparam: Int?): JSONArray {
        val response = get("$url${newIDparam ?: defaultID}", headers = headers)
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

    fun showData(sessionName: String) {
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
        "--filter" -> data.showData(args[1])
        "--names" -> data.showSessionNames()
        else -> println("Try one of this options:\n\t--all\n\t--filter <session name>\n\t--names")
    }
}

