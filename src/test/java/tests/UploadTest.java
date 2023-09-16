package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import services.WaitService;

public class UploadTest extends BaseTest {

    @Test
    public void uploadFileTest() {
        loginStep.successLogin(DataHelper.getUserToLogin());

        driver.get("https://vka.testmonitor.com/settings/users/3");

        WaitService waitService = new WaitService(driver);

        WebElement fileUploadElement = waitService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = UploadTest.class.getClassLoader().getResource("smiling-face.png").getPath();

        try {
            fileUploadElement.sendKeys(pathToFile.substring(1, pathToFile.length()));
        } catch (NoSuchElementException e) {
            System.out.println("File isn't found.");
        }

        waitService.waitForVisibilityLocatedBy(By.cssSelector("img.is-rounded")).click();
    }
}
