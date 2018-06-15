import cucumber.api.java8.En
import org.junit.Assert
import utils.parseDateToEpoch

/**
 * Created by Albert Sendros on 15/6/18. Project -> test-easygoband Package
 */
class DatesTest : En {
    private var stringDate: String = ""
    private var epochLong = 0L

    init {
        Given("^a date (\\d+)-(\\d+)-(\\d+)T(\\d+):(\\d+):(\\d+)\\.(\\d+)Z$") { arg1: Int, arg2: Int, arg3: Int, arg4: Int, arg5: Int, arg6: Int, _: Int ->
            var month = arg2.toString()
            if (arg2 < 10)
                month = "0$arg2"
            var day = arg3.toString()
            if (arg3 < 10)
                day = "0$arg3"
            this.stringDate = "$arg1-$month-${day}T$arg4:$arg5:${arg6}.000Z"
        }

        When("^I call the parseDateToEpoch method$") {
            this.epochLong = parseDateToEpoch(this.stringDate)
        }

        Then("^I will obtain (\\d+)$") { arg1: Int ->
            Assert.assertNotEquals(0L, this.epochLong)
            Assert.assertEquals(arg1.toLong(), this.epochLong)
        }
    }
}