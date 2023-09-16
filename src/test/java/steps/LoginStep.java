package steps;

import baseEntities.BaseStep;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {

    static Logger logger = LogManager.getLogger(LoginStep.class);

    public LoginStep (WebDriver driver){
        super(driver);
    }

    public ProjectsPage successLogin (User user){
        loginPage.login(user);
        logger.info("User is logged in");
        return projectsPage;
    }

    public LoginPage negativeLogin(String username, String password) {
        loginPage.login(username, password);
        logger.info("Attempt to log in with invalid creds");
        return loginPage;
    }


}
