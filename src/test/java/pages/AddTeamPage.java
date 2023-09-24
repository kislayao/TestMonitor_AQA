package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddTeamPage extends BasePage {

    @FindBy(xpath = "//input[@type = 'text']")
    public WebElement nameOfTeamInput;

    @FindBy(css = ".button.is-success")
    public WebElement addButton;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement submitAddButton;

    public AddTeamPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.xpath("//input[@type='text']");
    }

    public WebElement getNameOfTeamInput() {
        return nameOfTeamInput;
    }

    public void setNameOfTeamInput(String value) {
        getNameOfTeamInput().sendKeys(value);
    }
}
