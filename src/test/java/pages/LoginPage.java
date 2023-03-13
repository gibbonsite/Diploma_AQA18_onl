package pages;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By userNameInputLocator = By.id("login_field");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.cssSelector("input[value='Sign in']");

    public WebElement getUserNameInput() { return driver.findElement(userNameInputLocator);}
    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}
    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}
}
