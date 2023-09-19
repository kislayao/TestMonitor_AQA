package steps;

import baseEntities.BaseStep;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.UsersPage;

public class AddUserStep extends BaseStep {

    static Logger logger = LogManager.getLogger(AddUserStep.class);

    public AddUserStep(WebDriver driver) {
        super(driver);
    }

    public UsersPage addValidUser(User user) {

        addUserPage.addUser(user);
        logger.info("New user is added");
        return usersPage;
    }
}
