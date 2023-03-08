package pages.repository.fileoperations;

import baseentities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadingPage extends BasePage {
    private final By commitChangesElementLocator = By.xpath("//button[contains(text(), 'Commit changes')]");
    private final By fileElementLocator = By.id("upload-manifest-files-input");
    private final By commitTitleLocator = By.id("commit-summary-input");

    public WebElement getFileElement() { return driver.findElement(fileElementLocator);}
    public WebElement getCommitChangesElement() { return driver.findElement(commitChangesElementLocator);}
    public WebElement getCommitTitle() { return driver.findElement(commitTitleLocator);}
}
