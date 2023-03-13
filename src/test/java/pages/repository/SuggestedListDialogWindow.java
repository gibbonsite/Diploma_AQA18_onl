package pages.repository;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuggestedListDialogWindow extends BasePage {
    private final By listNameElementLocator = By.name("user_list[name]");

    public WebElement getListNameElement() {
        return driver.findElement(listNameElementLocator);
    }
}
