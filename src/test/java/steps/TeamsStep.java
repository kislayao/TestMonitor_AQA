package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddTeamPage;

public class TeamsStep extends BaseStep {

    public TeamsStep(WebDriver driver) {
        super(driver);
    }

    public AddTeamPage openAddTeamModel() {
        teamsPage.clickAddTeamButton();

        return addTeamPage;
    }
}
