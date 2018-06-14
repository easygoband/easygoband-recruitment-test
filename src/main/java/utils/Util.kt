package utils

import java.io.FileInputStream
import java.util.*

/**
 * Created by Albert Sendros on 30/5/18. Project -> test-easygoband Package utils
 */
object APIReader {
    private var properties: Properties = Properties()
    private var propertiesFile = "${System.getProperty("user.dir")}/src/main/resources/APIOptions.properties"

    init {
        val inputStream = FileInputStream(propertiesFile)
        properties.load(inputStream)
    }

    fun readApiKey(): String {
        return properties.getProperty("apikey")
    }

    fun apiURL(): String {
        return properties.getProperty("apiurl")
    }
}
