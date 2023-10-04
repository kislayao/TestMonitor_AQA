package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.commons.lang3.SystemUtils;
import org.testng.annotations.Test;
import pages.UsersPage;
import tests.api.AddProjectTest;

public class UploadTest extends BaseTest {

    private static String checkOperateSystemAndSendPathToFile() {
        String pathToFile;
        if (SystemUtils.IS_OS_WINDOWS) {
            pathToFile = AddProjectTest.class.getClassLoader().getResource("smiling-face.png").getPath()
                    .replace("/", "\\").substring(1);
        } else {
            pathToFile = AddProjectTest.class.getClassLoader().getResource("smiling-face.png").getPath();
        }
        return pathToFile;
    }

    @Test(description = "The image is loaded into the user's form.", groups = "positive tests")
    public void uploadFileTest()  {
        loginStep.successLogin(DataHelper.getUserToLogin());

        UsersPage usersPage = new UsersPage(driver);
        usersPage.openPageByUrl();
        usersStep.openUserProfile(0);
        userProfileStep.uploadAvatar(UploadTest.checkOperateSystemAndSendPathToFile());
        userProfileStep.clickRoundedImg();

    }
}
