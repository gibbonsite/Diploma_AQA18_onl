package runners;

import baseentities.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty.html",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = {"stepdefs", "hooks"},
        tags = "@DefectiveTest"
)
public class DefectiveCucumberTest extends BaseTest {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
