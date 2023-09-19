package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.AddUserPage;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.UsersPage;

public class BaseStep {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected SettingsPage settingsPage;
    protected UsersPage usersPage;
    protected AddUserForm addUserForm;
    protected UsersPage usersPage;
    protected AddUserPage addUserPage;

    public BaseStep (WebDriver driver){
        this.driver = driver;

        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        settingsPage = new SettingsPage(driver);
        usersPage = new UsersPage(driver);
        addUserForm = new AddUserForm(driver);
        addUserPage = new AddUserPage(driver);
    }

}
