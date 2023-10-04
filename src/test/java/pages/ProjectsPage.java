package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import services.WaitService;

public class ProjectsPage extends BasePage {
    public SettingsPage settingsPage;

    public ProjectsPage(WebDriver driver) {
        super(driver);

        settingsPage = new SettingsPage(driver);
    }

    @FindBy(xpath = "//*[@id='navMenu']/div[2]/a")
    public WebElement settingsLink;

    @FindBy(xpath = "//a[contains(@href, 'projects/1')]")
    public WebElement projectLink;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//h1[contains(@class, 'title') and contains(text(), 'Projects')]");
    }

    public void clickToSettings() {
        settingsLink.click();
    }

    WaitService waitService = new WaitService(driver);
    Actions actions = new Actions(driver);

    public void clickToProjectLink() {
        actions
                .click(waitService.waitForVisibility(projectLink))
                .build()
                .perform();
    }
}
