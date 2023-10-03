package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;
import services.WaitService;

public class TooltipTest extends BaseTest {
    static Logger logger = LogManager.getLogger(TooltipTest.class);

    @Test(testName = "Tooltip display test.", groups = "positive tests")
    public void tooltipTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        WaitService waitService = new WaitService(driver);

        ProjectPage projectPage = new ProjectPage(driver);
        projectPage.openPageByUrl();
        projectPage.clickTooltipElement();

        Assert.assertTrue(waitService.waitForVisibility(projectPage.tooltip).isDisplayed());
        logger.info("The tooltip about environment is displayed.");
    }
}
