package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.UsersPage;
import services.WaitService;

public class UploadTest extends BaseTest {
    static Logger logger = LogManager.getLogger(UploadTest.class);

    @Test(description = "The image is loaded into the user's form.", groups = "positive tests")
    public void uploadFileTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        UsersPage usersPage = new UsersPage(driver);
        usersPage.openPageByUrl();
        usersPage.clickDetailsAboutUserButton();

        WaitService waitService = new WaitService(driver);

        WebElement fileUploadElement = waitService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = UploadTest.class.getClassLoader().getResource("smiling-face.png").getPath();

        try {
            fileUploadElement.sendKeys(pathToFile.substring(1, pathToFile.length()));
        } catch (NoSuchElementException e) {
            logger.error("File isn't found.");
        }

        waitService.waitForVisibilityLocatedBy(By.cssSelector("img.is-rounded")).click();

        logger.info("File is uploaded.");
    }
}
