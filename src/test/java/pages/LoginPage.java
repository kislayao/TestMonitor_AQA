package pages;

import baseEntities.BasePage;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final static String pagePath = "/login";

    // Блок описания локаторов для элементов
    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy (id = "password")
    public WebElement passwordInput;

    @FindBy (className = "button")
    public WebElement loginButton;

    @FindBy (className = "message-body")
    public WebElement errorMessage;

    // Блок инициализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return By.className("button");
    }

    // Блок атомарных методов

    // Блок комплексных методов
    public void login(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        loginButton.submit();
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.submit();
    }

}
