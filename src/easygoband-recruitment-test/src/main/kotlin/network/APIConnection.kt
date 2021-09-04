package network

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

import model.Access

/**
 * Class in charge of managing the API.
 */
class APIConnection() {
    /**
     * Constants used by the API connection helper class.
     */
    companion object {
        private const val API_BASE_URL = "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/"
        private const val EVENT_ID = "1"
        private const val API_URL = API_BASE_URL + EVENT_ID
        private const val AUTHORIZATION_TOKEN = "cJmAc71jah17sgqi1jqaksvaksda="
        private const val AUTHORIZATION_HEADER = "Basic " + AUTHORIZATION_TOKEN
    }

    /**
     * Function in charge of making an API call.
     *
     * @return List retrieved from the server.
     */
    fun makeAPICall(): List<Access> {
        val client = HttpClient.newBuilder().build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(API_URL))
            .GET()
            .header("Authorization", AUTHORIZATION_HEADER)
            .header("Content-Type", "application/json")
            .build()

        try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofString())

            return Gson().fromJson(response.body(), Array<Access>::class.java).toList()
        } catch(e: JsonSyntaxException) {
            println("Error! No valid data could be retrieved.")
        }

        return emptyList()
    }
}