package main

import utils.APIReader

/**
 * Created by Albert Sendros on 30/5/18. Project -> test-easygoband Package main
 */
fun main(args: Array<String>) {
    val apiReader = APIReader()
    println(apiReader.readApiKey())
    println(apiReader.apiURL())
}