package stepdefs.ui;

import baseentities.BaseCucumberStepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.EditUserStatusDialogWindow;

import java.util.List;

public class UserStatusStepDefs extends BaseCucumberStepDefs {
    @When("user selects user status menu item")
    public void selectUserStatusMenuItem() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getUserProfileMenuDownArrowElement().click();
        dashboardPage.getUserStatusElement().click();
    }

    @Then("user status dialog window appears")
    public void openUserStatusDialogWindow() {
        EditUserStatusDialogWindow editUserStatusDialogWindow = new EditUserStatusDialogWindow();
        List<WebElement> dialogWindowElements = List.of(editUserStatusDialogWindow.getWindowHeaderElement(),
                editUserStatusDialogWindow.getUserStatusElement(),
                editUserStatusDialogWindow.getUserIsBusyElement(),
                editUserStatusDialogWindow.getClearStatusCheckboxElement(),
                editUserStatusDialogWindow.getSetUserStatusElement());
        dialogWindowElements.forEach(waitsService::waitForElementVisible);
    }
}
