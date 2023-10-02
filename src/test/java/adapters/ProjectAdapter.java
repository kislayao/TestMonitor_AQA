package adapters;

<<<<<<< HEAD
=======
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
>>>>>>> origin/feature/addAdapters
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
<<<<<<< HEAD
=======
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.json.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/feature/addAdapters

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

<<<<<<< HEAD
=======
    private Gson gson = new Gson();
>>>>>>> origin/feature/addAdapters

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