package pages.repository.fileoperations;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDeletionPage extends BasePage {
    private final By deleteFileElementLocator = By.id("submit-file");

    public WebElement getDeleteFileElement() { return driver.findElement(deleteFileElementLocator);}
}
