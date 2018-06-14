import cucumber.api.java8.En
import org.junit.Assert

/**
 * Created by Albert Sendros on 14/6/18. Project -> test-easygoband Package
 */
class HelloWorldTest : En {
    var firstNum: Int = 0
    var secondNum: Int = 0

    init {
        Given("^I have two numbers$") {
            // Write code here that turns the phrase above into concrete actions
        }
        When("^I have (\\d+) \\+ (\\d+)$") { firstNum: Int, secondNum: Int ->
            this.firstNum = firstNum
            this.secondNum = secondNum
        }

        Then("^I will see (\\d+)$") { result: Int ->
            Assert.assertEquals(result, this.firstNum + this.secondNum)
        }

    }
}
