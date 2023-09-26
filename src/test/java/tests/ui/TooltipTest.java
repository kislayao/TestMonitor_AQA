package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import pages.SettingsPage;
import services.WaitService;

import java.util.List;

public class TooltipTest extends BaseTest {
    static Logger logger = LogManager.getLogger(TooltipTest.class);

    @Test(testName = "Tooltip display test.", groups = "positive tests")
    public void tooltipTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPageByUrl();
        settingsPage.clickToProjectsMenuLabel();
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.clickToProjectLink();

        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitService.waitForAllVisibleElementsLocatedBy(By.cssSelector
                ("div.tooltip-trigger"));

        actions
                .moveToElement(targetElements.get(1), 5,5)
                .click()
                .build()
                .perform();

        Assert.assertTrue(waitService.waitForVisibilityLocatedBy(By.xpath
                ("//div[2]/div/div[contains(text(), 'Chrome')]")).isDisplayed());
        logger.info("The tooltip about environment is displayed.");
    }
}
