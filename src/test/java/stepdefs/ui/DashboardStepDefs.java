package stepdefs.ui;

import baseentities.BaseCucumberStepDefs;
import core.configuration.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardStepDefs extends BaseCucumberStepDefs {
    private DashboardPage dashboardPage;
    private LoginPage loginPage;

    @Given("login page is opened")
    public void openLoginPage() {
        loginPage = new LoginPage();
        loginPage.openPageByUrl("/login");
    }

    @And("user with his login and password is logged in")
    public void logInUserWithUsernameAndPassword() {
        loginPage.getUserNameInput().sendKeys(ReadProperties.getAuthenticationConfig().gitHubUsername());
        loginPage.getPassword().sendKeys(ReadProperties.getAuthenticationConfig().gitHubPassword());
        loginPage.getLogInButton().click();

        dashboardPage = new DashboardPage();
    }


    @When("user hovers over the {string} repository in the repository list")
    public void hoverOverRepository(String repository) {
        new Actions(driver)
                .moveToElement(dashboardPage.getRepositoryElement(repository))
                .build()
                .perform();
    }

    @Then("pop-up window with repository brief info appears")
    public void showUpPopupWindow() {
        waitsService.waitForElementVisible(dashboardPage.getPopupWindowElement());
    }
}
