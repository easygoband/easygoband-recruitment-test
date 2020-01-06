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
