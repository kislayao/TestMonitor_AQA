package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import services.WaitService;

public class SettingsPage extends BasePage {
    private final static String pagePath = "/settings";

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1.title")
    public WebElement headerTitle;

    @FindBy(xpath = "//li/a[contains(@href, 'projects')]")
    public WebElement projectsMenuLabel;

    @FindBy(xpath = "//ul[3]/li/ul/li[1]/a")
    public WebElement usersMenuLabel;

    @FindBy(xpath = "//ul[3]/li/ul/li[2]/a")
    public WebElement teamsMenuLabel;

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("h1.title");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    WaitService waitService = new WaitService(driver);
    Actions actions = new Actions(driver);

    public void clickToProjectsMenuLabel() {
        actions
                .click(waitService.waitForVisibility(projectsMenuLabel))
                .build()
                .perform();
    }

    public void clickToUsersMenuLabel() {
        usersMenuLabel.click();
    }

    public void clickToTeamsMenuLabel() {
        teamsMenuLabel.click();
    }
}
