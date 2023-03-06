package adapters;


import baseEntitites.BaseCucumberTest;
import configurationForApi.DataBaseService;
import dbTables.EmailDbTable;
import io.restassured.response.Response;
import models.Email;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.*;

public class EmailAdapter{
    Logger logger = LogManager.getLogger(EmailAdapter.class);
    Response response;
    EmailDbTable emailDbTable;


    public void addEmailToGithub() {
        logger.info("Add email in GitHub");

        response = given()
                .when()
                .log().all()
                .body(emailDbTable.getEmails())
                .post(ADD_AN_EMAILS)
                .then().log().body().extract().response();
    }

    public void responseStatusAddEmail() {
        assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
    }

    public void getEmailsList() {
        logger.info("Get email in GitHub");
        response = given()
                .when()
                .log().all()
                .get(GET_LIST_EMAILS)
                .then()
                .log().body()
                .extract()
                .response();
    }
    public void responseGetStatusEmail(){assertEquals(response.getStatusCode(), HttpStatus.SC_OK);}

    public Response deleteEmail() {

        return given()
                .body(emailDbTable.getEmails())
                .when()
                .log().all()
                .delete(DELETE_AN_EMAILS)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
