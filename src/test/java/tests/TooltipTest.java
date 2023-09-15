package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitService;

import java.util.List;

public class TooltipTest extends BaseTest {

    @Test
    public void tooltipTest(){
        loginStep.successLogin(DataHelper.getUserToLogin());

        driver.get("https://vka.testmonitor.com/settings/projects/1");

        WaitService waitService = new WaitService(driver);
        Actions actions = new Actions(driver);

        List<WebElement> targetElements = waitService.waitForAllVisibleElementsLocatedBy(By.cssSelector("div.tooltip-trigger"));

        actions
                .moveToElement(targetElements.get(1), 5,5)
                .click()
                .build()
                .perform();

    }
}
