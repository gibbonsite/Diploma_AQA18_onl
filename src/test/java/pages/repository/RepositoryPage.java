package pages.repository;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryPage extends BasePage {
    private final By repositoryHeaderElementLocator = By.cssSelector(
            "#repository-container-header strong > a");
    private final By repositorySettingsElementLocator = By.id("settings-tab");
    private final By addFileElementLocator = By.xpath(
            "//*[contains(@class, 'file-navigation')]//span[contains(text(), 'Add file')]");
    private final By createNewFileMenuItemElementLocator = By.xpath(
            "//button[contains(text(), 'Create new file')]");
    private final By uploadFilesMenuItemElementLocator = By.linkText("Upload files");
    private final By repositoryContentsElementLocator = By.xpath(
            "//*[contains(@class, 'file-navigation')]/following-sibling::*[1]");
    private final By repositoryFileElementsLocator = By.xpath(
            "//*[contains(@class, 'Box-row')]/*[2]//a");

    private final By suggestedListsDownArrowElementLocator = By.xpath(
            "//div[contains(@class, 'unstarred')]//*[contains(@class, 'user-list-menu')]/summary");

    private final By createSuggestedListElementLocator = By.xpath(
            "//*[contains(text(), 'Suggested lists')]/ancestor::details-menu//footer/button");

    public WebElement getRepositoryHeaderElement() {
        return driver.findElement(repositoryHeaderElementLocator);
    }

    public WebElement getRepositorySettingsElement() {
        return driver.findElement(repositorySettingsElementLocator);
    }

    public WebElement getAddFileElement() {
        return driver.findElement(addFileElementLocator);
    }

    public WebElement getCreateNewFileMenuItemElement() {
        return driver.findElement(createNewFileMenuItemElementLocator);
    }

    public WebElement getUploadFilesMenuItemElement() {
        return driver.findElement(uploadFilesMenuItemElementLocator);
    }

    public List<String> getRepositoryFileNames() {
        Wait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class);

        return (List<String>) wait.until((driver) -> {
                WebElement repositoryContentsElement = ((WebDriver) driver).findElement(repositoryContentsElementLocator);
            return repositoryContentsElement.findElements(repositoryFileElementsLocator)
                    .stream()
                    .map((webElement) -> webElement.getText())
                    .collect(Collectors.toList());
        });
    }

    public WebElement getSuggestedListsDownArrowElement() {
        return driver.findElement(suggestedListsDownArrowElementLocator);
    }

    public WebElement getCreateSuggestedListElement() {
        return driver.findElement(createSuggestedListElementLocator);
    }
}
