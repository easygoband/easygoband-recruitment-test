/**
 * Created by Albert Sendros on 14/6/18. Project -> test-easygoband Package
 */
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(plugin = arrayOf("pretty"), features = ["src/test/resources"], tags = ["not @ignored"])
class CucumberTest