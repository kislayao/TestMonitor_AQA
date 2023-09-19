package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddUserForm;
import pages.SettingsPage;
import pages.UsersPage;

public class AddingUserStep extends BaseStep {

    public AddingUserStep(WebDriver driver) {
        super(driver);
    }

    public SettingsPage addingProjectSettings() {
        projectsPage.clickToSettings();

        return settingsPage;
    }

    public UsersPage addingUser() {
        addingProjectSettings().clickToUsersMenuLabel();

        return usersPage;
    }

    public AddUserForm openUserForm() {
        usersPage.clickAddUserButton();

        return addUserForm;
    }
}
