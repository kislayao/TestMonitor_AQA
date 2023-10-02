package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.UserProfilePage;
import services.WaitService;

public class UserProfileStep extends BaseStep {

    static Logger logger = LogManager.getLogger(UserProfileStep.class);
    WaitService waitService = new WaitService(driver);

    public UserProfileStep(WebDriver driver) {
        super(driver);
    }

    public UserProfilePage openDeleteUserModal() {
        userProfilePage.moreOptionButton.click();
        userProfilePage.deleteOption.click();
        logger.info("Delete user modal is opened");
        return userProfilePage;
    }

    public UserProfilePage uploadAvatar(String path) {
        waitService.waitForExists(By.xpath("//input[@type='file']")).sendKeys(path);
        logger.info("File is uploaded");
        return userProfilePage;
    }

    public UserProfilePage clickRoundedImg(){
        waitService.waitForExists(By.cssSelector("img.is-rounded")).click();
        return userProfilePage;
    }

}
