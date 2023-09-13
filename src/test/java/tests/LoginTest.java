package tests;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest(){

        Assert.assertTrue(loginStep.successLogin(DataHelper.getUserToLogin()).isPageOpened());

    }
}
