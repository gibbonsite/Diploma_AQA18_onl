package pages.repository.fileoperations;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileCreationPage extends BasePage {
    private final By fileNameElementLocator = By.cssSelector("input[name='filename']");
    private final By commitTitleLocator = By.id("commit-summary-input");
    private final By commitNewFileElementLocator = By.id("submit-file");

    public WebElement getFileNameElement() { return driver.findElement(fileNameElementLocator);}
    public WebElement getCommitTitle() { return driver.findElement(commitTitleLocator);}
    public WebElement getCommitNewFileElement() { return driver.findElement(commitNewFileElementLocator);}
}
