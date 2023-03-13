package pages.repository;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepositoryCreationPage extends BasePage {
    private final By repositoryCreationErrorMessageElementLocator = By.xpath(
            "//div[contains(text(), 'Repository creation failed.')]");
    private final By repositoryNameElementLocator = By.id("repository_name");
    private final By repositoryDescriptionElementLocator = By.id("repository_description");
    private final By publicRepositoryElementLocator = By.id("repository_visibility_public");
    private final By privateRepositoryElementLocator = By.id("repository_visibility_private");
    private final By createRepositoryElementLocator = By.xpath(
            "//button[contains(text(), 'Create repository')]");

    public WebElement getRepositoryCreationErrorMessageElement() {
        return driver.findElement(repositoryCreationErrorMessageElementLocator);
    }

    public WebElement getRepositoryNameElement() {
        return driver.findElement(repositoryNameElementLocator);
    }

    public WebElement getRepositoryDescriptionElement() {
        return driver.findElement(repositoryDescriptionElementLocator);
    }

    public WebElement getPublicOrPrivateRepositoryElement(boolean isPublic) {
        return driver.findElement(isPublic ? publicRepositoryElementLocator : privateRepositoryElementLocator);
    }

    public WebElement getCreateRepositoryElement() {
        return driver.findElement(createRepositoryElementLocator);
    }

}
