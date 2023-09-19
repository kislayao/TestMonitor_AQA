package baseEntities;

import browserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.AddingUserStep;
import steps.AddUserStep;
import steps.LoginStep;
import steps.UsersStep;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected AddingUserStep addingUserStep;
    protected UsersStep usersStep;
    protected AddUserStep addUserStep;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        loginStep = new LoginStep(driver);
        usersStep = new UsersStep(driver);
        addUserStep = new AddUserStep(driver);
        driver.get(ReadProperties.getUrl());
        addingUserStep = new AddingUserStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
