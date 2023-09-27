package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NegativeGetProjectTest extends BaseApiTest {
    static Logger logger = LogManager.getLogger(NegativeGetProjectTest.class);
    @Test
    public void negativeGetProjectTest() {

        String endpoint = "/api/v1/projects/{projectId}";
        int projectID = 1200;

        given()
                .pathParam("projectId", projectID)
                .log().all()
                .get(endpoint)
                .then()
                .log().status()
                .statusCode(HttpStatus.SC_NOT_FOUND);

        logger.info("Project ID: " + projectID);
        logger.info("Project with this ID Not Found.");
    }
}
