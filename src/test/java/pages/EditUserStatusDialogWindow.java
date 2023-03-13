package pages;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditUserStatusDialogWindow extends BasePage {
    private final By dialogWindowElementLocator = By.xpath(
            "//*[contains(text(), 'Edit status')]/ancestor::details-dialog");
    private final By userStatusElementLocator = By.name("message");
    private final By windowHeaderElementLocator = By.xpath("//*[contains(text(), 'Edit status')]");
    private final By userIsBusyElementLocator = By.name("limited_availability");
    private final By setUserStatusElementLocator = By.cssSelector("[type='submit']");
    private final By clearStatusCheckboxLocator = By.xpath(
            "//div[contains(text(), 'Clear status')]/following-sibling::*[1]");

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
