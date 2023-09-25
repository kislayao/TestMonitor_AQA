package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DialogWindowTest extends BaseTest {
    static Logger logger = LogManager.getLogger(DialogWindowTest.class);

    @Test
    public void displayedDialogWindowTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());
        addUserStep.addingProjectSettings().clickToUsersMenuLabel();
        addUserStep.addingUser().clickAddUserButton();

        Assert.assertTrue(addUserStep.openUserForm().isPageOpened());
        logger.info("Dialog window Add User is displayed.");
    }
}
