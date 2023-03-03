import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/featuresApi"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = "apiSteps",
        tags = "@RegressionTest"
)
public class RunRegressionCucumberTest extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
