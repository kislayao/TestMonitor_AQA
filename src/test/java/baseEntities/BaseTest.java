package baseEntities;

import browserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.configuration.ReadProperties;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected UsersStep usersStep;
    protected AddUserStep addUserStep;
    protected UserProfileStep userProfileStep;
    protected ConfirmDeleteUserStep confirmDeleteUserStep;

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        this.setDriverToContext(iTestContext, driver);

        loginStep = new LoginStep(driver);
        usersStep = new UsersStep(driver);
        addUserStep = new AddUserStep(driver);
        userProfileStep = new UserProfileStep(driver);
        confirmDeleteUserStep = new ConfirmDeleteUserStep(driver);
        driver.get(ReadProperties.getUrl());
    }

    private void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
