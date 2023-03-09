package stepdefs;

import baseentities.BaseCucumberStepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import model.ui.Repository;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.DashboardPage;
import pages.UserProfilePage;
import pages.repository.RepositoryCreationPage;
import pages.repository.RepositoryDeletionDialogWindow;
import pages.repository.RepositoryPage;
import pages.repository.RepositorySettingsPage;
import pages.repository.fileoperations.FileUploadingPage;

@Log4j2
public class RepositoryStepDefs extends BaseCucumberStepDefs {

    private RepositoryCreationPage repositoryCreationPage;

    @Given("repository creation page is opened")
    public void openRepositoryPage() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getRepositoryCreationElement().click();
    }

    @When("new repository {string} is created")
    public void createRepository(String repositoryName) {
        Repository repository = Repository.builder()
                .name(repositoryName)
                .description("Repository for running tests of Diploma AQA18-onl.")
                .isPublic(true)
                .build();
        log.info("Creating repository " + repository);

        RepositoryCreationPage repositoryCreationPage = new RepositoryCreationPage();
        repositoryCreationPage.getRepositoryNameElement().sendKeys(repository.getName());
        repositoryCreationPage.getRepositoryDescriptionElement().sendKeys(repository.getDescription());
        repositoryCreationPage.getPublicOrPrivateRepositoryElement(repository.isPublic()).click();
        waitsService.waitForElementIsEnabled(repositoryCreationPage.getCreateRepositoryElement())
                .click();
    }

    @Then("repository {string} page is opened")
    public void openRepositoryPage(String repository) {
        RepositoryPage repositoryPage = new RepositoryPage();
        Assert.assertEquals(repositoryPage.getRepositoryHeaderElement().getText(),
                repository);
    }

    @Given("user {string} opens repository {string} page")
    public void openRepositoryPage(String username, String repository) {
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.openPageByUrl("/" + username + "/" + repository);
    }

    @And("repository settings page is opened")
    public void openRepositorySettings() {
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.getRepositorySettingsElement().click();
    }

    @When("repository {string} of user {string} is deleted")
    public void deleteRepository(String repository, String username) {
        RepositorySettingsPage repositorySettingsPage = new RepositorySettingsPage();
        repositorySettingsPage.getRepositoryDeletionElement().click();
        RepositoryDeletionDialogWindow repositoryDeletionDialogWindow = new RepositoryDeletionDialogWindow();
        repositoryDeletionDialogWindow.getDeletionConfirmationElement().sendKeys(username + "/" + repository);
        repositoryDeletionDialogWindow.getRepositoryDeletionElement().click();
    }

    @Then("message about successful repository deletion is shown")
    public void showMessageAboutSuccessfulRepositoryDeletion() {
        UserProfilePage userProfilePage = new UserProfilePage();
        Assert.assertTrue(userProfilePage.getInformationMessageElement().isDisplayed());
    }

    @And("file upload page is opened for repository {string} of user {string}")
    public void openFileUploadPage(String repository, String username) {
        RepositoryPage repositoryPage = new RepositoryPage();
        repositoryPage.getAddFileElement().click();
        waitsService.waitForElementVisible(repositoryPage.getUploadFilesMenuItemElement())
                .click();
    }

    @When("file is uploaded to a repository")
    public void uploadFileToRepository() {
        FileUploadingPage fileUploadingPage = new FileUploadingPage();
        String pathToFile = RepositoryStepDefs.class.getClassLoader().getResource("upload.png").getPath()
                .substring(1);
        fileUploadingPage.getFileElement().sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.xpath(
                "//*[contains(@class, 'manifest-file-list')]//*[contains(@class, 'remove-manifest-file')]/button"));
        fileUploadingPage.getCommitTitle().sendKeys("File upload.png added");
        fileUploadingPage.getCommitChangesElement().click();
    }

    @When("repository with extremely long description is attempted to create")
    public void attemptToCreateRepositoryWithExtremelyLongDescription() {
        Repository repository = Repository.builder()
                .name("RepositoryLong01")
                .description("Repository has an extremely long description length. " + "1".repeat(    350))
                .isPublic(true)
                .build();
        log.info("Attempting to create the repository " + repository);

        repositoryCreationPage = new RepositoryCreationPage();
        repositoryCreationPage.getRepositoryNameElement().sendKeys(repository.getName());
        repositoryCreationPage.getRepositoryDescriptionElement().sendKeys(repository.getDescription());
        repositoryCreationPage.getPublicOrPrivateRepositoryElement(repository.isPublic()).click();
        waitsService.waitForElementIsEnabled(repositoryCreationPage.getCreateRepositoryElement())
                .click();
    }

    @Then("input check message about extremely long repository description is shown")
    public void showErrorMessageAboutExtremelyLongRepositoryDescription() {
        waitsService.waitForElementVisible(repositoryCreationPage.getRepositoryCreationErrorMessageElement());
    }
}
