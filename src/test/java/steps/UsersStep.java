package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddUserPage;
import pages.SettingsPage;
import pages.UsersPage;
import services.WaitService;

import java.util.List;

import static java.lang.Thread.sleep;

public class UsersStep extends BaseStep {

    static Logger logger = LogManager.getLogger(UsersStep.class);
    WaitService waitService = new WaitService(driver);

    public UsersStep(WebDriver driver) {
        super(driver);
    }

    public AddUserPage openAddUserModal() {

        usersPage.addUserButton.click();
        logger.info("Modal for adding user is opened");
        return addUserPage;

    }

    public int getAmountOfUsers() throws InterruptedException {
        sleep(2000);
        List<WebElement> displayedUsers = waitService.waitForAllVisibleElementsLocatedBy(
                By.xpath("//tbody/tr"));
        logger.info("Amount of users displayed on the page: " + displayedUsers.size());
        return displayedUsers.size();
    }

}
