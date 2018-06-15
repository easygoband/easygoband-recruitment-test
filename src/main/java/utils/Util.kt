package utils

import java.io.FileInputStream
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
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

fun parseDateToEpoch(stringDate: String): Long {
    val myDate = LocalDate.parse(stringDate.dropLast(5), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    val zoneId = ZoneId.of("Europe/Madrid") // or: ZoneId.of("Europe/Oslo");
    return myDate.atStartOfDay(zoneId).toEpochSecond()
}