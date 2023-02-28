package stepdefs;

import baseentities.BaseCucumberTest;
import factory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import model.Repository;
import pages.DashboardPage;
import pages.repository.RepositoryCreationPage;
import pages.repository.RepositoryPage;
import pages.repository.RepositorySettingsPage;
import pages.repository.fileoperations.FileDeletionPage;
import services.WaitsService;

@Log4j2
public class Hook extends BaseCucumberTest {
    @Before
    public void initScenario(Scenario scenario) {
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
    }

    @After
    public void completeScenario(Scenario scenario) {
        if (driver != null) {
            switch (scenario.getName()) {
                case "Repository creation":
                    deleteRepository("AnotherRepository");
                    break;
                case "Boundary test for repository creation":
                    deleteRepository("A");
                    deleteRepository("A3A5A7A9A12A15A18A21A24A27A30A33A36A39A42A45A48A51A54A57A60A63A66A69A72A75A78A81A84A87A90A93A96A100A");
                    break;
                case "Repository deletion":
                    DashboardPage dashboardPage = new DashboardPage(driver);
                    dashboardPage.openPageByUrl("/");
                    dashboardPage.getRepositoryCreationElement().click();

                    Repository repository = Repository.builder()
                            .name("RepositoryDeletion01")
                            .description("Repository for running tests of Diploma AQA18-onl.")
                            .isPublic(true)
                            .build();
                    log.info("Recreating repository " + repository);

                    RepositoryCreationPage repositoryCreationPage = new RepositoryCreationPage(driver);
                    repositoryCreationPage.getRepositoryNameElement().sendKeys(repository.getName());
                    repositoryCreationPage.getRepositoryDescriptionElement().sendKeys(repository.getDescription());
                    repositoryCreationPage.getPublicOrPrivateRepositoryElement(repository.isPublic()).click();
                    waitsService.waitForElementIsEnabled(repositoryCreationPage.getCreateRepositoryElement())
                            .click();
                    break;
                case "Create file in a repository":
                    FileDeletionPage fileDeletionPage = new FileDeletionPage(driver);
                    fileDeletionPage.openPageByUrl("/DiplomaAqa18Onl/FirstRepository/delete/main/empty.txt");
                    fileDeletionPage.getDeleteFileElement().click();
                    break;
            }
            driver.quit();
        }
    }

    private void deleteRepository(String repository) {
        RepositoryPage repositoryPage = new RepositoryPage(driver);
        repositoryPage.openPageByUrl("/DiplomaAqa18Onl/" + repository);
        if (driver.getTitle().contains("Page not found")) {
            return;  // repository does not exist -- skip deletion
        }

        repositoryPage.getRepositorySettingsElement().click();
        RepositorySettingsPage repositorySettingsPage = new RepositorySettingsPage(driver);
        repositorySettingsPage.getRepositoryDeletionElement().click();
        RepositorySettingsPage.RepositoryDeletionPage repositoryDeletionPage =
                new RepositorySettingsPage.RepositoryDeletionPage(driver);
        repositoryDeletionPage.getDeletionConfirmationElement().sendKeys("DiplomaAqa18Onl/" + repository);
        repositoryDeletionPage.getRepositoryDeletionElement().click();
    }
}
