package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    public SettingsPage settingsPage;

    public ProjectsPage(WebDriver driver) {
        super(driver);

        settingsPage = new SettingsPage(driver);
    }

    @FindBy(xpath = "//div[@class = 'navbar-end']/a[1]")
    public WebElement settingsLink;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//h1[contains(@class, 'title') and contains(text(), 'Projects')]");
    }

    public void clickToSettings() {
        settingsLink.click();
    }
}
