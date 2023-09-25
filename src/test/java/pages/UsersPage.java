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

    @FindBy(xpath = "//td[4]/div/a[contains(@href, 'users/1')]")
    public WebElement detailsAboutUserButton;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//div[2]/div/button");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
        logger.info("Users page is opened");
    }

    WaitService waitService = new WaitService(driver);
    Actions actions = new Actions(driver);

    public void clickDetailsAboutUserButton() {
        actions
                .click(waitService.waitForVisibility(detailsAboutUserButton))
                .build()
                .perform();
    }

    public void clickAddUserButton() {
        actions
                .click(waitService.waitForVisibility(addUserButton))
                .build()
                .perform();
    }
}
