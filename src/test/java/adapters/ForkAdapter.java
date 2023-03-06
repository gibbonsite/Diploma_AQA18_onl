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

    Logger logger = LogManager.getLogger(ForkAdapter.class);
    Response response;

    public void createFork() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        logger.info("Creating Fork in GitHub");
        Map<String, Object> repo = new HashMap<>();
        repo.put("name", "TestForkAdded");

        response = given()
                .pathParams("owner", ReadProperties.username())
                .pathParam("repo", "Test_Repo_11231")
                .when()
                .log().all()
                .body(repo)
                .post(CREATE_A_FORK)
                .then().log().all().extract().response();
    }

    public void checkAddedForkStatus(){
        assertEquals(response.statusCode(),202);
    }
}
