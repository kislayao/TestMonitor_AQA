package steps;

import baseEntities.BaseStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.ConfirmDeleteUserPage;
import pages.UsersPage;

public class ConfirmDeleteUserStep extends BaseStep {
    static Logger logger = LogManager.getLogger(ConfirmDeleteUserStep.class);

    public ConfirmDeleteUserStep(WebDriver driver) {
        super(driver);
    }

    public ConfirmDeleteUserPage setConfirmationFlag(){
        confirmDeleteUserPage.confirmationCheckbox.click();
        logger.info("Confirmation flag is set");
        return confirmDeleteUserPage;
    }

    public UsersPage pressDeleteButton(){
        confirmDeleteUserPage.deleteUserButton.click();
        logger.info("Delete button is clicked");
        return usersPage;
    }


}
