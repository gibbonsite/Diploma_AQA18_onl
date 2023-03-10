package stepdefs.ui;

import baseentities.BaseCucumberStepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.repository.RepositoryPage;
import pages.repository.fileoperations.FileCreationPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class FileCreationStepDefs extends BaseCucumberStepDefs {
    @And("file creation page is opened")
    public void openFileCreationPage() {
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.getAddFileElement().click();
        waitsService.waitForElementVisible(repositoryPage.getCreateNewFileMenuItemElement())
                .click();
    }

    @When("new file is created")
    public void createNewFile() {
        FileCreationPage fileCreationPage = new FileCreationPage();
        fileCreationPage.getFileNameElement().sendKeys("empty.txt");
        fileCreationPage.getCommitTitle().sendKeys("empty.txt is added");
        fileCreationPage.getCommitNewFileElement().click();
    }

    @Then("new file is shown in the repository contents")
    public void showNewFileInRepositoryContents() {
        RepositoryPage repositoryPage = new RepositoryPage();
        List<String> repositoryFileNames = repositoryPage.getRepositoryFileNames();

        assertThat(repositoryFileNames, hasItem("empty"));
    }
}
