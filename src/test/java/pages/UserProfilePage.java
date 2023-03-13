package pages;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserProfilePage extends BasePage {
    private final By informationMessageElementLocator = By.xpath(
            "//*[contains(text(), 'was successfully deleted')]");

    public WebElement getInformationMessageElement() { return driver.findElement(informationMessageElementLocator);}
}
