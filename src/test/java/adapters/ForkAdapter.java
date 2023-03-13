package adapters;

import core.configuration.ReadProperties;
import io.restassured.response.Response;
import models.Fork;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.*;

public class ForkAdapter {

    Logger logger = LogManager.getLogger(ForkAdapter.class);
    Response response;

    public void createFork(Fork fork) {
        logger.info("Creating Fork in GitHub");
        response = given()
                .pathParams("owner", ReadProperties.getAuthenticationConfig().gitHubUsername())
                .pathParam("repo", "Test_Repo_11231")
                .when()
                .log().all()
                .body(fork)
                .post(CREATE_A_FORK)
                .then().log().all().extract().response();
    }

    public void checkAddedForkStatus() {
        assertEquals(response.statusCode(), HttpStatus.SC_ACCEPTED);
    }
}
