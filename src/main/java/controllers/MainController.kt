package controllers

import utils.APIReader

/**
 * Created by Albert Sendros on 14/6/18. Project -> test-easygoband Package controllers
 */
fun getInfo() {
    val result = khttp.get(
            url = APIReader.apiURL(),
            headers = mapOf("Authorization" to "Basic ${APIReader.readApiKey()}"))
    println(result.text)
}