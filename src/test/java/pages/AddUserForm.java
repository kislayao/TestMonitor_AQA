package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserForm extends BasePage {

    public AddUserForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement buttonCancel;

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//button[contains(text(), 'Cancel')]");
    }
}
