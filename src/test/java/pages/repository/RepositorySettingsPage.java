package pages.repository;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepositorySettingsPage extends BasePage {
    private final By repositoryDeletionElementLocator = By.xpath(
            "//summary[contains(text(), 'Delete this repository')]");

    public RepositorySettingsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRepositoryDeletionElement() {
        return driver.findElement(repositoryDeletionElementLocator);

    }

    public static class RepositoryDeletionPage extends BasePage {
        private final By deletionConfirmationElementLocator = By.xpath(
                "//*[contains(text(), 'Unexpected bad things')]/following-sibling::*[1]//input[@type='text']");
        private final By repositoryDeletionElementLocator = By.xpath(
                "//*[contains(text(), 'consequences, delete this repository')]/..");

        public RepositoryDeletionPage(WebDriver driver) {
            super(driver);
        }

        public WebElement getDeletionConfirmationElement() {
            return driver.findElement(deletionConfirmationElementLocator);
        }

        public WebElement getRepositoryDeletionElement() {
            return driver.findElement(repositoryDeletionElementLocator);
        }
    }
}
