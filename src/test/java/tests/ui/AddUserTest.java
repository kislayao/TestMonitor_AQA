package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UsersPage;

public class AddUserTest extends BaseTest {

    @Test
    public void addUser() throws InterruptedException {

        loginStep.successLogin(DataHelper.getUserToLogin());

        UsersPage usersPage = new UsersPage(driver);
        usersPage.openPageByUrl();

        int amountOfUsers = usersStep.getAmountOfUsers();
        usersStep.openAddUserModal();
        addUserStep.addValidUser(DataHelper.getUserToAdd());
        int amountOfUsersAfterNewUserWasAdded = usersStep.getAmountOfUsers();
        Assert.assertEquals(amountOfUsers, amountOfUsersAfterNewUserWasAdded - 1);
    }
}
