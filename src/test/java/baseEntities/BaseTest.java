package baseEntities;

import browserFactory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.AddingUserStep;
import steps.LoginStep;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected AddingUserStep addingUserStep;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        loginStep = new LoginStep(driver);
        driver.get(ReadProperties.getUrl());
        addingUserStep = new AddingUserStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
