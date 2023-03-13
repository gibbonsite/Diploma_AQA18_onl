package stepdefs.ui;

import baseentities.BaseCucumberStepDefs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.repository.RepositoryPage;
import pages.repository.SuggestedListDialogWindow;

public class SuggestedListStepDefs extends BaseCucumberStepDefs {
    private SuggestedListDialogWindow suggestedListDialogWindow;

    @When("incorrect suggested list name is entered")
    public void enterIncorrectSuggestedListName() {
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.getSuggestedListsDownArrowElement().click();
        repositoryPage.getCreateSuggestedListElement().click();
        suggestedListDialogWindow = new SuggestedListDialogWindow();
        suggestedListDialogWindow.getListNameElement().sendKeys("%$#");
    }

    @Then("error message about incorrect suggested list name is shown")
    public void showErrorMessageAboutIncorrectSuggestedListName() {
        waitsService.waitForVisibilityBy(By.xpath(
                "//*[contains(text(), 'at least one alphanumeric character') and contains(@id,'input-check')]"));
    }
}
