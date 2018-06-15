package controllers

import cqrs.QueryHandler
import cqrs.QueryTypes
import dataclasses.MyData
import dataclasses.parseJsonToMyData
import org.json.JSONObject

/**
 * Created by Albert Sendros on 14/6/18. Project -> test-easygoband Package controllers
 */
fun getInfo(): List<MyData> {
    val res = QueryHandler.executeQuery(QueryTypes.BasicQuery)
    val myDataList = mutableListOf<MyData>()
    res.jsonArray.forEach { myDataList.add(parseJsonToMyData(it as JSONObject)) }
    return myDataList
}
