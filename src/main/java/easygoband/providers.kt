package easygoband

import java.io.FileInputStream
import java.util.Properties

class Providers() {
    private var properties: Properties = Properties()
    private var propertiesFile = "c:/users/igorr/IdeaProjects/EasyGoBand/src/main/resources/provider.properties"

    init {
        val inputStream = FileInputStream(propertiesFile)
        properties.load(inputStream)
    }

    fun getApiURL(): String {
        return properties.getProperty("apiurl")
    }

    fun getApiEventID(): Int {
        return properties.getProperty("eventid").toInt()
    }

    fun getApiKey(): String {
        return properties.getProperty("apikey").plus('=')
    }
}
