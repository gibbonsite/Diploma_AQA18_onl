package adapters;


import io.restassured.response.Response;
import models.Email;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.*;

public class EmailAdapter {
    Logger logger = LogManager.getLogger(EmailAdapter.class);
    Response response;

    public void addEmailToGithub(List<Email> body) {
        logger.info("Add email in GitHub");

        response = given()
                .when()
                .log().all()
                .body(body)
                .post(ADD_AN_EMAILS)
                .then().log().body().extract().response();
    }

    public void responseStatusAddEmail() {
        assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
    }

    public void getEmailsList() {
        logger.info("Get emails list in GitHub");
        response = given()
                .when()
                .log().all()
                .get(GET_LIST_EMAILS)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public void responseGetStatusEmail() {
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    public void deleteEmail(List<Email> body) {

        given()
                .body(body)
                .when()
                .log().all()
                .delete(DELETE_AN_EMAILS)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
