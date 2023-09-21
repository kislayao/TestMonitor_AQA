package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.UsersPage;

public class BoundaryValueTest extends BaseTest {
    static Logger logger = LogManager.getLogger(BoundaryValueTest.class);

    @Test
    public void successBoundaryValueTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        UsersPage usersPage = new UsersPage(driver);
        usersPage.openPageByUrl();
        usersStep.openAddUserModal();

        AddUserPage addUserPage = new AddUserPage(driver);

        String firstName = "Elizabeth-Caroline";

        addUserPage.setFirstNameInput(firstName);

        int length = firstName.length();
        logger.info("Length of the input value of the FirstName field is: " + length);

        if (length <= 100) {
            logger.info("Length of the input value doesn't exceed the required.");
        }
    }

    @Test
    public void negativeBoundaryValueTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        UsersPage usersPage = new UsersPage(driver);
        usersPage.openPageByUrl();
        usersStep.openAddUserModal();

        AddUserPage addUserPage = new AddUserPage(driver);

        String firstName = "Uhniyc87nyxoiuyhidhiughknkeuolriurjikhkjhikkujiurjghkjximhchfnihmxjfxo-4mijghfkrjfmoxijmmofmxrjkgjmfo";

        addUserPage.setFirstNameInput(firstName);

        int length = firstName.length();
        logger.info("Length of the input value of the FirstName field is: " + length);

        if (length > 100) {
            logger.error("Length of the input value exceed the required 100 symbols.");
        }
    }
}
