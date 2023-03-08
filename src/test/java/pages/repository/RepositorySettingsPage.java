package pages.repository;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepositorySettingsPage extends BasePage {
    private final By repositoryDeletionElementLocator = By.xpath(
            "//summary[contains(text(), 'Delete this repository')]");

    public WebElement getRepositoryDeletionElement() {
        return driver.findElement(repositoryDeletionElementLocator);

    }
}
