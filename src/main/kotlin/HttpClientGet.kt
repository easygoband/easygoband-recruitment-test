package easygoband.recruitment.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


// from https://stackoverflow.com/a/46179139
object HttpClient {
    var cache: String? = null

    fun sendGet(): String {
        if (cache != null ) {
            return cache as String
        }
        val url = "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1"
        val obj = URL(url)

        with(obj.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"
            setRequestProperty("Authorization", "Basic cJmAc71jah17sgqi1jqaksvaksda=")

            println("\nSending 'GET' request to URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }

                cache = response.toString()
                return response.toString()
            }
        }
    }
}