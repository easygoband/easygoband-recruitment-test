package easygoband.recruitment.test

import ratpack.handling.Context
import ratpack.handling.Handler

class MyHandler constructor(private val myService: MyService) : Handler {
    override fun handle(ctx: Context) {
        ctx.response.send("service value: ${myService.getValue()}")
    }
}