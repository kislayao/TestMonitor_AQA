package helper;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import models.Project;

public class GsonHelper {
    private static Gson gson = new Gson();

    public static Project getProjectFromJson(Response response) {
        JsonObject respAsJsonObject = gson.fromJson(response.getBody().asString(), JsonObject.class);
        JsonElement respAsJsonElement = respAsJsonObject.getAsJsonObject("data");
        return gson.fromJson(respAsJsonElement, Project.class);
    }

}
