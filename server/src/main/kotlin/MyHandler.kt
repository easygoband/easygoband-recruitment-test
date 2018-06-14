package easygoband.recruitment.test

import ratpack.handling.Context
import ratpack.handling.Handler

class MyHandler constructor(private val myService: MyService) : Handler {
    override fun handle(ctx: Context) {
        ctx.response.headers.add("Access-Control-Allow-Origin", "*")
        ctx.response.headers.add("Content-Type", "application/json")
        ctx.response.send("${myService.getValue()}")
    }
}