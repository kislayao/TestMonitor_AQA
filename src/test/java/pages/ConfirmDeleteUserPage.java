package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmDeleteUserPage extends BasePage {

    public ConfirmDeleteUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[@class = 'check is-danger']")
    public WebElement confirmationCheckbox;

    @FindBy (xpath = "//button[@class = 'button is-danger']")
    public WebElement deleteUserButton;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//p[@class = 'modal-card-title'][contains(text(), 'Are you sure?')]");
    }
}
