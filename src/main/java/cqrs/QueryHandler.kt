package cqrs

import khttp.responses.Response

/**
 * Created by Albert Sendros on 14/6/18. Project -> test-easygoband Package cqrs
 */
object QueryHandler {

    fun executeQuery(query: Query): Response {
        return query.execute()
    }

}