package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.response.Response;
import models.Project;
import org.apache.commons.lang3.SystemUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import helper.GsonHelper;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AddProjectTest extends BaseApiTest {

    static Logger logger = LogManager.getLogger(AddProjectTest.class);
    private Project actualProject;

    private static String checkOperateSystemAndSendPathToFile() {
        String pathToFile;
        if (SystemUtils.IS_OS_WINDOWS) {
            pathToFile = AddProjectTest.class.getClassLoader().getResource("expectedProject.json").getPath()
                    .replace("/", "\\").substring(1);
        } else {
            pathToFile = AddProjectTest.class.getClassLoader().getResource("expectedProject.json").getPath();
        }
        return pathToFile;
    }

    public Project getActualProject() {
        return actualProject;
    }

    @Test
    public void addProject() throws FileNotFoundException {

        Gson gson = new Gson();

        FileReader reader = new FileReader(AddProjectTest.checkOperateSystemAndSendPathToFile());
        Project expectedProject = gson.fromJson(reader, Project.class);

        Response response = new ProjectAdapter().add(expectedProject);
        actualProject = GsonHelper.getProjectFromJson(response);

        logger.info("Actual project: " + actualProject.toString());
        logger.info("Expected project: " + expectedProject.toString());

        Assert.assertTrue(expectedProject.equals(actualProject));

    }
}
