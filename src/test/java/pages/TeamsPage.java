package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import services.WaitService;

public class TeamsPage extends BasePage {

    private final static String pagePath = "/settings/teams";

    public TeamsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[2]/div/button")
    public WebElement addTeamButton;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//div[2]/div/button");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public void clickAddTeamButton() {
        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);
        actions
                .click(waitService.waitForVisibility(addTeamButton))
                .build()
                .perform();
    }
}
