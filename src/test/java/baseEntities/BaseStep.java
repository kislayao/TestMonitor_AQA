package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected SettingsPage settingsPage;
    protected UsersPage usersPage;
    protected AddUserForm addUserForm;

    public BaseStep (WebDriver driver){
        this.driver = driver;

        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        settingsPage = new SettingsPage(driver);
        usersPage = new UsersPage(driver);
        addUserForm = new AddUserForm(driver);
    }
}
