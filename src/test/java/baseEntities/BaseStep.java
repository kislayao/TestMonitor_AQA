package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected SettingsPage settingsPage;
    protected UsersPage usersPage;
    protected AddUserPage addUserPage;
    protected TeamsPage teamsPage;
    protected AddTeamPage addTeamPage;
    protected UserProfilePage userProfilePage;
    protected ConfirmDeleteUserPage confirmDeleteUserPage;

    public BaseStep (WebDriver driver){
        this.driver = driver;

        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        settingsPage = new SettingsPage(driver);
        usersPage = new UsersPage(driver);
        addUserPage = new AddUserPage(driver);
        teamsPage = new TeamsPage(driver);
        addTeamPage = new AddTeamPage(driver);
        userProfilePage = new UserProfilePage(driver);
        confirmDeleteUserPage = new ConfirmDeleteUserPage(driver);
    }
}
