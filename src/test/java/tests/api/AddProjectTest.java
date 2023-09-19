package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.commons.lang3.SystemUtils;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class AddProjectTest extends BaseApiTest {

    static Logger logger = LogManager.getLogger(AddProjectTest.class);
    private Project actualProject;

    private static String checkOperateSystemAndSendPathToFile() {
        String pathToFile;
        if (SystemUtils.IS_OS_WINDOWS) {
            System.out.println("Windows Operating System");
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

        String endpoint = "/api/v1/projects";

        FileReader reader = new FileReader(AddProjectTest.checkOperateSystemAndSendPathToFile());
        Project expectedProject = gson.fromJson(reader, Project.class);

        Response response = given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();

        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);
        JsonElement respAsJsonElement = respAsJsonObject.getAsJsonObject("data");

        actualProject = gson.fromJson(respAsJsonElement, Project.class);

        logger.info("Actual project: " + actualProject.toString());
        logger.info("Expected project: " + expectedProject.toString());

        Assert.assertTrue(expectedProject.equals(actualProject));

    }
}
