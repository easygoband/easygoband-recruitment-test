import com.google.gson.Gson
import controllers.getInfo
import org.json.JSONException
import spark.Request
import spark.Response
import spark.Spark.get
import spark.Spark.port
import utils.acceptedPaths
import utils.afterEveryResponse
import utils.cors
import utils.getHerokuAssignedPort

/**
 * Created by Albert Sendros on 30/5/18. Project -> test-easygoband Package main
 */
fun main(args: Array<String>) {
    port(getHerokuAssignedPort())
    cors()
    spark.Spark.init()
    afterEveryResponse()

    get(acceptedPaths[0]) { _: Request, response: Response ->
        try {
            response.status(200)
            Gson().toJson(getInfo())

        } catch (exception: JSONException) {
            response.status(500)
            Gson().toJson(mapOf("message" to "Error during the JSON parse, something wrong."))
        }
    }
}