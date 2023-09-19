package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowTest extends BaseTest {

    @Test
    public void displayedDialogWindowTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());
        addUserStep.addingProjectSettings().clickToUsersMenuLabel();
        addUserStep.addingUser().clickAddUserButton();

        Assert.assertTrue(addUserStep.openUserForm().isPageOpened());
    }
}
