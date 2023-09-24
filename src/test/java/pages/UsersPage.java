package pages;

import baseEntities.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import services.WaitService;

public class UsersPage extends BasePage {

    static Logger logger = LogManager.getLogger(UsersPage.class);

    private final static String pagePath = "/settings/users";

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[2]/div/button")
    public WebElement addUserButton;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//div[2]/div/button");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
        logger.info("Users page is opened");
    }

    public void clickAddUserButton() {
        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);
        actions
                .click(waitService.waitForVisibility(addUserButton))
                .build()
                .perform();
    }
}
