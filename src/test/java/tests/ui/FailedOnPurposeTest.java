package tests.ui;

import baseEntities.BaseTest;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedOnPurposeTest extends BaseTest {

    @Test
    public void failedTest(){
        Assert.assertFalse(loginStep.successLogin(DataHelper.getUserToLogin()).isPageOpened());
    }
}
