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

public class ForkAdapter {
    Response response;
    Logger logger = LogManager.getLogger(RepositoryAdapter.class);

    public void createFork() {
        logger.info("Creating Repository in GitHub");
        Map<String, Object> repo = new HashMap<>();
        repo.put("name", "TestForkAdded");

        response = given()
                .pathParams("owner", ReadProperties.username())
                .pathParam("repo", "Test_Repo_11231")
                .when()
                .body(repo)
                .post(CREATE_A_FORK)
                .then().log().all().extract().response();
    }

    public void checkAddedForkStatus(){
        assertEquals(response.statusCode(),202);
    }
}
