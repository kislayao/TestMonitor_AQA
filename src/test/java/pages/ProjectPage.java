package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import services.WaitService;

import java.util.List;

public class ProjectPage extends BasePage {

    private final static String pagePath = "/settings/projects/1";

    @FindBy(xpath = "//*[@class='tooltip-content' and contains(text(), 'Chrome')]")
    public WebElement tooltip;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.cssSelector("h1.title");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public void clickTooltipElement() {
        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitService.waitForAllVisibleElementsLocatedBy(By.cssSelector
                ("div.tooltip-trigger"));

        actions
                .moveToElement(targetElements.get(1), 5,5)
                .click()
                .build()
                .perform();
    }
}
