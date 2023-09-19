package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {
    private final static String pagePath = "/settings";

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1.title")
    public WebElement headerTitle;

    @FindBy(xpath = "//ul[3]/li/ul/li[1]/a")
    public WebElement usersMenuLabel;

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("h1.title");
    }

    public void clickToUsersMenuLabel() {
        usersMenuLabel.click();
    }
}
