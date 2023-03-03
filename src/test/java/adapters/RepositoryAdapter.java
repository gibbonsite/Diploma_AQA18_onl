package adapters;

import configurationForApi.ReadProperties;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.*;

public class RepositoryAdapter {
    private static Response response;

    Logger logger = LogManager.getLogger(RepositoryAdapter.class);

    public void createRepository() {
        logger.info("Creating Repository in GitHub");
        Map<String, Object> repo = new HashMap<>();
        repo.put("name", "Test");
        repo.put("description", "test1");
        repo.put("private", false);
        response = given()
                .when()
                .body(repo)
                .post(AUTHENTICATED_USER_REPO)
                .then().log().all().extract().response();
    }
    public void checkCreatedStatus(){

        assertEquals(response.statusCode(),201);
    }
    public Response getRepo(String repo, String owner){

        return given()
                .pathParams("owner", ReadProperties.username())
                .pathParam("repo", "Test")
                .when()
                .get(GET_REPO)
                .then()
                .log().body()
                .extract()
                .response();
    }
    public Response deleteRepo(){

        return given()
                .pathParam("owner", ReadProperties.username())
                .pathParam("repo", "Test")
                .when()
                .delete(DELETE_REPO)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
