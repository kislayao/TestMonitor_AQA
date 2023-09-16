package tests.ui;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import utils.configuration.ReadProperties;

public class LoginWithInvalidCredsTest extends BaseTest {

    static Logger logger = LogManager.getLogger(LoginWithInvalidCredsTest.class);

    @Test
    public void failLoginTest() {

        Assert.assertEquals(loginStep.negativeLogin(ReadProperties.email(), "12345U")
                        .errorMessage.getText().trim(),
                "These credentials do not match our records.");

        logger.info("Error message for logging with invalid creds is displayed");
    }
}
