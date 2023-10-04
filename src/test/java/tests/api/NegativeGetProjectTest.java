package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class NegativeGetProjectTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(NegativeGetProjectTest.class);

    @Test
    public void negativeGetProjectTest() {

        Response response = new ProjectAdapter().getProject();

        logger.info("Http Status Code " + response.statusCode());
        logger.info("Project with this ID Not Found.");
    }
}
