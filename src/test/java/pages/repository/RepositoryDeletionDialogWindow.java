package pages.repository;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RepositoryDeletionDialogWindow extends BasePage {
    private final By deletionConfirmationElementLocator = By.xpath(
            "//*[contains(text(), 'Unexpected bad things')]/following-sibling::*//input[@type='text']");
    private final By repositoryDeletionElementLocator = By.xpath(
            "//*[contains(text(), 'consequences, delete this repository')]/..");

    public WebElement getDeletionConfirmationElement() {
        return driver.findElement(deletionConfirmationElementLocator);
    }

    public WebElement getRepositoryDeletionElement() {
        return driver.findElement(repositoryDeletionElementLocator);
    }
}
