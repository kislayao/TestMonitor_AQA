package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public Response add(Project expectedProject) {

        return given()
                .body(expectedProject, ObjectMapperType.GSON)
                .log().all()
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
    }

    public Response getAllProjects() {

        return given()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public Response getProject() {
        int projectID = 1200;

        return given()
                .pathParam("projectId", projectID)
                .log().all()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().status()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract()
                .response();
  }
}