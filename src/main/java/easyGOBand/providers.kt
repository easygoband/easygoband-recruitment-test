package easyGOBand.easyGOBand

import java.io.FileInputStream
import java.util.Properties

class Providers() {
    private var properties: Properties = Properties()
    private var propertiesFile = "src/main/resources/provider.properties"

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
        return properties.getProperty("apikey").plus( '=')
    }
}
