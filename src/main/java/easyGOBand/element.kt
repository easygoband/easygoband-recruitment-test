package easyGOBand

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Element() {
    /*
    Fields returned by REST API:
        access_group_name, access_group_id, total_uses, sessions, event_id,
        structure_decode, name, modified, id, basic_product_id
     */
    internal var id: Int = 0
    internal var name: String = ""
    private var modified: LocalDateTime = LocalDateTime.now()
    private var sessions: MutableList<Session> = mutableListOf()
    internal var accessGroupID: Int = 0
    internal var accessGroupName: String = ""
    internal var totalUses: Int = 0
    internal var eventID: Int = 0
    internal var structureDecode: Boolean = false
    internal var basicProductID: Int = 0

    fun setModified(modified: String) {
        this.modified = LocalDateTime.parse(modified, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
    }

    private fun getModified(): String {
        return modified.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }

    fun addSession(session: Session){
        this.sessions.add(session)
    }

    fun getSessionNames(): String {
        var sessionNames = ""
        for (session in sessions)
            sessionNames += session.name + ", "
        sessionNames = sessionNames.trimEnd(' ', ',')
        return sessionNames
    }

    fun hasSessionName(sessionName: String): Boolean {
        for (session in sessions) {
            if (session.name == sessionName)
                return true
        }
        return false
    }

    fun show() {
        println("\tID: $id\n\tNAME: $name\n\tSESSIONS: ${getSessionNames()}\n\tACCESS GROUP NAME: $accessGroupName")
        println("\tTOTAL USES: $totalUses\n\tEVENT ID: $eventID\n\tBASIC PROD. ID: $basicProductID")
        println("\tSTRUCTURE DECODE: $structureDecode\n\tMODIFIED: ${getModified()}")
    }
}
