package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListOfAllProjectsTest extends BaseApiTest{

    static Logger logger = LogManager.getLogger(GetListOfAllProjectsTest.class);

    @Test
    public void getAllProjectsTest(){

        String endpoint = "/api/v1/projects";


        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

    }
}
