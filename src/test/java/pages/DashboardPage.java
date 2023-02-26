package pages;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final By repositoryListElementLocator = By.xpath(
            "//*[contains(@class, 'dashboard-sidebar')]//*[contains(text(), 'Top Repositories')]/..");
    private final By userStatusElementLocator = By.xpath("//summary[contains(@class, 'user-status-edit')]");
    private final By popupWindowElementLocator = By.className("Popover");
    private final By repositoryCreationElementLocator = By.xpath(
            "//*[contains(@class, 'dashboard-sidebar')]//h2/a");
    private final By userProfileMenuDownArrowElementLocator = By.xpath(
            "//details[contains(@class, 'feature-preview')]/summary");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserStatusElement() {
        return driver.findElement(userStatusElementLocator);
    }

    public WebElement getRepositoryElement(String repository) {
        WebElement repositoryListElement = driver.findElement(repositoryListElementLocator);
        By repositoryElementLocator = By.partialLinkText(repository);
        return repositoryListElement.findElement(repositoryElementLocator);
    }

    public WebElement getPopupWindowElement() {
        return driver.findElement(popupWindowElementLocator);
    }

    public WebElement getRepositoryCreationElement() {
        return driver.findElement(repositoryCreationElementLocator);
    }

    public WebElement getUserProfileMenuDownArrowElement() {
        return driver.findElement(userProfileMenuDownArrowElementLocator);
    }

    public static class EditUserStatusDialogWindow extends BasePage {
        private final By dialogWindowElementLocator = By.xpath(
                "//*[contains(text(), 'Edit status')]/ancestor::details-dialog");
        private final By userStatusElementLocator = By.name("message");
        private final By windowHeaderElementLocator = By.xpath("//*[contains(text(), 'Edit status')]");
        private final By userIsBusyElementLocator = By.name("limited_availability");
        private final By setUserStatusElementLocator = By.cssSelector("[type='submit']");
        private final By clearStatusCheckboxLocator = By.xpath(
                "//div[contains(text(), 'Clear status')]/following-sibling::*[1]");

        public EditUserStatusDialogWindow(WebDriver driver) {
            super(driver);
        }

        public WebElement getUserStatusElement() {
            return getDialogWindowElement().findElement(userStatusElementLocator);
        }

        public WebElement getUserIsBusyElement() {
            return getDialogWindowElement().findElement(userIsBusyElementLocator);
        }

        public WebElement getWindowHeaderElement() {
            return getDialogWindowElement().findElement(windowHeaderElementLocator);
        }

        public WebElement getSetUserStatusElement() {
            return getDialogWindowElement().findElement(setUserStatusElementLocator);
        }

        public WebElement getClearStatusCheckboxElement() {
            return getDialogWindowElement().findElement(clearStatusCheckboxLocator);
        }

        private WebElement getDialogWindowElement() {
            return driver.findElement(dialogWindowElementLocator);
        }
    }
}
