package stepdefs;

import baseentities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;

import java.util.List;

public class UserStatusStepDefs extends BaseCucumberTest {
    @When("user selects user status menu item")
    public void selectUserStatusMenuItem() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.getUserProfileMenuDownArrowElement().click();
        dashboardPage.getUserStatusElement().click();
    }

    @Then("user status dialog window appears")
    public void openUserStatusDialogWindow() {
        DashboardPage.EditUserStatusDialogWindow editUserStatusDialogWindow =
                new DashboardPage.EditUserStatusDialogWindow(driver);
        List<WebElement> dialogWindowElements = List.of(editUserStatusDialogWindow.getWindowHeaderElement(),
                editUserStatusDialogWindow.getUserStatusElement(),
                editUserStatusDialogWindow.getUserIsBusyElement(),
                editUserStatusDialogWindow.getClearStatusCheckboxElement(),
                editUserStatusDialogWindow.getSetUserStatusElement());
        dialogWindowElements.forEach(waitsService::waitForElementVisible);
    }
}
