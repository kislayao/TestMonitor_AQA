package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class UsersPage extends BasePage {

    private final static String pagePath = "/settings/users";

    @FindBy(xpath = "//button[contains(text(), 'Add User...')]")
    public WebElement addUserButton;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//button[contains(text(), 'Add User...')]");
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
