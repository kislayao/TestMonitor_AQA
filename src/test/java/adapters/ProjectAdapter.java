package adapters;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public Response add(Project expectedProject) {

        String endpoint = "/api/v1/projects";

        return given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
    }

}