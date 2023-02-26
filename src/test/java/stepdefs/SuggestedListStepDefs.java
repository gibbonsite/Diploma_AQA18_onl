package stepdefs;

import baseentities.BaseCucumberTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.repository.RepositoryPage;

public class SuggestedListStepDefs extends BaseCucumberTest {
    private RepositoryPage.SuggestedListDialogWindow suggestedListDialogWindow;

    @When("incorrect suggested list name is entered")
    public void enterIncorrectSuggestedListName() {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.getSuggestedListsDownArrowElement().click();
        repositoryPage.getCreateSuggestedListElement().click();
        suggestedListDialogWindow = new RepositoryPage.SuggestedListDialogWindow(driver);
        suggestedListDialogWindow.getListNameElement().sendKeys("%$#");
    }

    @Then("error message about incorrect suggested list name is shown")
    public void showErrorMessageAboutIncorrectSuggestedListName() {
        waitsService.waitForVisibilityBy(By.xpath(
                "//*[contains(text(), 'at least one alphanumeric character') and contains(@id,'input-check')]"));
    }
}
