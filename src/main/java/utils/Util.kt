package utils

import spark.Filter
import spark.Spark
import spark.kotlin.after
import spark.kotlin.before
import java.io.FileInputStream
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*


/**
 * Created by Albert Sendros on 30/5/18. Project -> test-easygoband Package utils
 */
val acceptedPaths = listOf("/api/data")
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

fun cors() {
    Spark.options("/*") { request, response ->
        val accessControlRequestHeaders = request
                .headers("Access-Control-Request-Headers")
        if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Allow-Headers",
                    accessControlRequestHeaders)
        }

        val accessControlRequestMethod = request
                .headers("Access-Control-Request-Method")
        if (accessControlRequestMethod != null) {
            response.header("Access-Control-Allow-Methods",
                    accessControlRequestMethod)
        }

        "OK"
    }
    before(filter = Filter { _, response -> response.header("Access-Control-Allow-Origin", "*") })
}

fun afterEveryResponse() {
    after { response.type("application/json") }
}

fun getHerokuAssignedPort(): Int {
    val processBuilder = ProcessBuilder()
    return if (processBuilder.environment()["PORT"] != null)
        Integer.parseInt(processBuilder.environment()["PORT"])
    else 4567
}