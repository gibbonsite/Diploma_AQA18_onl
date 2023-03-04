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
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        logger.info("Creating Repository in GitHub");
        Map<String, Object> repo = new HashMap<>();
        repo.put("name", "Test");
        repo.put("description", "test1");
        repo.put("private", false);
        response = given()
                .when()
                .log().all()
                .body(repo)
                .post(AUTHENTICATED_USER_REPO)
                .then().log().all().extract().response();
    }
    public void checkCreatedStatus(){
    if(response != null)
        assertEquals(response.statusCode(),201);
    }
    public void getRepo(String repo, String owner){
        logger.info("Get Repository in GitHub");
        response = given()
                .pathParams("owner", ReadProperties.username())
                .pathParam("repo", "Test")
                .when()
                .get(GET_REPO)
                .then()
                .log().body()
                .extract()
                .response();
    }
    public void checkGetStatus(){
        assertEquals(response.statusCode(), 200);
    }
    public Response deleteRepo(){
        logger.info("Delete Repository in GitHub");
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
