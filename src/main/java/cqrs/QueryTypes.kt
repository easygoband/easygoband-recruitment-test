package cqrs

import khttp.responses.Response
import utils.APIReader

/**
 * Created by Albert Sendros on 14/6/18. Project -> test-easygoband Package utils
 */
sealed class QueryTypes {
    object BasicQuery : Query {
        override fun execute(): Response {
            return khttp.get(
                    url = APIReader.apiURL(),
                    headers = mapOf("Authorization" to "Basic ${APIReader.readApiKey()}"))
        }
    }
}