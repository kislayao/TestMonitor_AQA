package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import services.WaitService;

import java.util.ArrayList;
import java.util.List;

public class BoundaryValueTest extends BaseTest {
    static Logger logger = LogManager.getLogger(BoundaryValueTest.class);

    @Test(groups = "positive tests", priority = 1)
    public void successBoundaryValueTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        WaitService waitService = new WaitService(driver);

        TeamsPage teamsPage = new TeamsPage(driver);
        teamsPage.openPageByUrl();
        teamsStep.openAddTeamModel();

        AddTeamPage addTeamPage = new AddTeamPage(driver);
        WebElement input = addTeamPage.nameOfTeamInput;

        List<String> namesOfTeamsList = new ArrayList<>();
        namesOfTeamsList.add("1");
        namesOfTeamsList.add("RW");
        namesOfTeamsList.add("Dgfhrytgjhjjhnhffrtrrytytrt67uijkjgddssghg6u8iujh" +
                "r4ee655787ikghffgfdgfssfdsrsrhjmjhjdeeebmj,jjjjkgh");
        namesOfTeamsList.add("Dgfhrytgjhjjhnhffrtrrytytrt67uijkjgddssghg6u8iujh" +
                "r4ee655787ikghffgfdgfssfdsrsrhjmjhjdeeebmj,jjjjkgh1");

        for (int i = 0; i < namesOfTeamsList.size(); i++) {
            String value = namesOfTeamsList.get(i);
            int lengthOfInputName = value.length();
            if (lengthOfInputName >= 1 && lengthOfInputName <= 100) {
                input.sendKeys(value);

                logger.info("Length of the input value of the NameOfTeam field is: " + lengthOfInputName);
                logger.info("It doesn't exceed the required.");

                Assert.assertTrue(waitService.waitForVisibility(addTeamPage.submitAddButton).isDisplayed());
                logger.info("Add button is active.");

                input.sendKeys(Keys.CONTROL + "a");
                input.sendKeys(Keys.DELETE);
            }
        }
    }

    @Test(groups = "negative tests", priority = 2)
    public void negativeBoundaryValueTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        TeamsPage teamsPage = new TeamsPage(driver);
        teamsPage.openPageByUrl();
        teamsStep.openAddTeamModel();

        AddTeamPage addTeamPage = new AddTeamPage(driver);

        String teamName = "";
        addTeamPage.setNameOfTeamInput(teamName);

        int lengthOfTeamName = teamName.length();
        logger.info("Length of the input value of the TeamName field is: " + lengthOfTeamName);

        Assert.assertEquals(1, driver.findElements(By.cssSelector("button:disabled")).size());
        logger.error("You can't add Team with ZERO size of name!");

        String teamName2 = "Dgfhrytgjhjjhnhffrtrrytytrt67uijkjgddssghg6u8iujh" +
                "r4ee655787ikghffgfdgfssfdsrsrhjmjhjdeeebmj,jjjjkgh12";
        addTeamPage.setNameOfTeamInput(teamName2);

        int lengthOfTeamName2 = teamName2.length();
        logger.info("Length of the input value of the TeamName field is: " + lengthOfTeamName2);

        Assert.assertNotEquals(addTeamPage.nameOfTeamInput.getText(), "Dgfhrytgjhjjhnhffrtrrytytrt67uijkjgdd" +
                "ssghg6u8iujhr4ee655787ikghffgfdgfssfdsrsrhjmjhjdeeebmj,jjjjkgh12");
        logger.error("If your TeamName is more then 100 symbols size, the TeamName will be cut to 100 symbols.");
    }
}
