package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.UserProfilePage;

public class UserProfileStep extends BaseStep {

    static Logger logger = LogManager.getLogger(UserProfileStep.class);

    public UserProfileStep(WebDriver driver) {
        super(driver);
    }

    public UserProfilePage openDeleteUserModal() {
        userProfilePage.moreOptionButton.click();
        userProfilePage.deleteOption.click();
        logger.info("Delete user modal is opened");
        return userProfilePage;
    }

}
