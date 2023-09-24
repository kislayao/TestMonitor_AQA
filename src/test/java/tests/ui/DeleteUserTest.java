package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UsersPage;

public class DeleteUserTest extends BaseTest {

    @Test (description = "Delete user test")
    public void deleteUser() throws InterruptedException {

        loginStep.successLogin(DataHelper.getUserToLogin());

        UsersPage usersPage = new UsersPage(driver);
        usersPage.openPageByUrl();

        int amountOfUsers = usersStep.getAmountOfUsers();
        usersStep.openUserProfile(1);

        userProfileStep.openDeleteUserModal();
        confirmDeleteUserStep.setConfirmationFlag();
        confirmDeleteUserStep.pressDeleteButton();
        int amountOfUsersAfterUserWasDeleted = usersStep.getAmountOfUsers();
        Assert.assertEquals(amountOfUsers - 1, amountOfUsersAfterUserWasDeleted);
    }
}
