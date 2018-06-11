package easygoband.recruitment.test

import ratpack.server.BaseDir


fun main(args: Array<String>) {

    val handler = MyHandler(MyServiceImpl)

    try {
        createServer(handler).start()
    } catch (e: Exception) {
        println(e)
        System.exit(1)
    }

}

fun createServer(handler: MyHandler) = serverOf {
    serverConfig {
        baseDir(BaseDir.find())
        port(8080)
    }

    handlers {
        it.get(handler)
    }
}

