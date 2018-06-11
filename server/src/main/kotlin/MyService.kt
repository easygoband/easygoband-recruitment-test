package easygoband.recruitment.test

interface MyService {
    fun getValue(): String
}

object MyServiceImpl : MyService {
    override fun getValue() = HttpClient.sendGet()
}

