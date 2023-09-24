package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends BasePage {

    @FindBy(xpath = "//div/input[@name='first_name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//div/input[@name='last_name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//div/input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//div/input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//div/input[@name='password_confirmation']")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//button/span[contains(text(), 'Add')]")
    public WebElement addButton;

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.className("modal-card-title");
    }

    public WebElement getFirstNameInput() {
        return  driver.findElement(By.xpath("//div/input[@name='first_name']"));
    }

    public void setFirstNameInput(String value) {
        getFirstNameInput().sendKeys(value);
    }

    public void addUser(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        confirmPasswordInput.sendKeys(user.getConfirmPassword());
        addButton.click();
    }

}
