package adapters;

import core.configuration.ReadProperties;
import io.restassured.response.Response;
import models.Repository;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.*;

public class RepositoryAdapter {
    private static Response response;

    Logger logger = LogManager.getLogger(RepositoryAdapter.class);

    public void createRepository(Repository repository) {
        logger.info("Creating Repository in GitHub");
        response = given()
                .when()
                .log().all()
                .body(repository)
                .post(AUTHENTICATED_USER_REPO)
                .then().log().all().extract().response();
    }

    public void checkCreatedStatus() {

        assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
    }

    public void getRepo() {
        logger.info("Get Repository in GitHub");
        response = given()
                .pathParams("owner", ReadProperties.getAuthenticationConfig().gitHubUsername())
                .pathParam("repo", "New-diploma-repo")
                .when()
                .get(GET_REPO)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public void checkGetStatus() {
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }

    public Response deleteRepo() {
        logger.info("Delete Repository in GitHub");
        return given()
                .pathParam("owner", ReadProperties.getAuthenticationConfig().gitHubUsername())
                .pathParam("repo", "New-diploma-repo")
                .when()
                .delete(DELETE_REPO)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
