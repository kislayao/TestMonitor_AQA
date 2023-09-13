package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class LoginStep extends BaseStep {

    public LoginStep (WebDriver driver){
        super(driver);
    }

    public ProjectsPage successLogin (User user){
        loginPage.login(user);
        return projectsPage;
    }


}
