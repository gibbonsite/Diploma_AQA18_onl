package adapters;


import core.configuration.ReadProperties;
import io.restassured.response.Response;

import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.*;

public class GetRequestsAdapters {
    Logger logger = LogManager.getLogger(GetRequestsAdapters.class);
    Response response;

    public void authorizationUserWantToGetInformationFromGithub() {
        logger.info("Get user info in GitHub");
        response = given()
                .get((USER_URL + "/" + ReadProperties.getAuthenticationConfig().gitHubUsername()))
                .then()
                .log().body()
                .extract().response();
    }

    public void theRequestedDataIsReturned() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    public void authorizationUserWantToGetAllInformationFromGithub() {
        logger.info("Get user info by username in GitHub");
        response = given()
                .get(USER_URL)
                .then()
                .log().body().extract().response();
    }

    public void theRequestedDataAllUserIsReturned() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    public void authorizationUserWantToGetEmojisInformationFromGithub() {
        logger.info("Get emojis info in GitHub");
        response = given()
                .get(GET_EMOJIS)
                .then()
                .log().body().extract().response();
    }

    public void theRequestedDataOfEmojisIsReturned() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    public void requestForEmojisWithDoubleToken() {

        logger.info("Get emojis with 2 tokens in GitHub");
        response = given()
                .when()
                .log().all()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + "lk;k;k;")
                .get(GET_EMOJIS)
                .then()
                .log().body().extract().response();
    }

    public void theRequesterDataReturnErrorBadRequest() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }


    public void authorizationUserWantToGetInformationFromGithubWithWrongEndpoint() {
        logger.info("Get repo info with wrong url");
        response = given()
                .get("//repo")
                .then()
                .log().body().extract().response();
    }


    public void theRequesterDataReturnErrorNotFoundError() {
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }
}

