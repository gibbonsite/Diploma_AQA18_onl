package stepdefs;

import baseentities.BaseCucumberTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardStepDefs extends BaseCucumberTest {
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @Given("login page is opened")
    public void openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPageByUrl("/login");
    }

    @And("user with login {string} and password {string} is logged in")
    public void logInUserWithUsernameAndPassword(String username, String password) {
        loginPage.getUserNameInput().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLogInButton().click();

        dashboardPage = new DashboardPage(driver);
    }


    @When("user hovers over the {string} repository in the repository list")
    public void hoverOverRepository(String repository) {
        new Actions(driver)
                .moveToElement(dashboardPage.getRepositoryElement(repository))
                .build()
                .perform();
    }

    @Then("pop-up window with repository {string} brief info appears")
    public void showUpPopupWindow(String repository) {
        waitsService.waitForElementVisible(dashboardPage.getPopupWindowElement());
    }
}
