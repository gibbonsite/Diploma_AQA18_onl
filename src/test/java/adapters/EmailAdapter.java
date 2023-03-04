package adapters;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.*;

public class EmailAdapter {
    Logger logger = LogManager.getLogger(EmailAdapter.class);
    Response response;

    public void addEmailToGithub() {
        logger.info("Add email in GitHub");
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        String[] emails = new String[1];
        emails[0] = "vshchatsko@gmail.com";

        response = given()
                .when()
                .log().all()
                .body(emails)
                .post(ADD_AN_EMAILS)
                .then().log().body().extract().response();
    }

    public void responseStatusAddEmail() {
        assertEquals(response.statusCode(), 201);
    }

    public Response getEmailsList() {
        logger.info("Get email in GitHub");
        return given()
                .when()
                .log().all()
                .get(GET_LIST_EMAILS)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public Response deleteEmail() {
        logger.info("Delete email in GitHub");
        String[] emails = new String[1];
        emails[0] = "vshchatsko@gmail.com";
        return given()
                .body(emails)
                .when()
                .log().all()
                .delete(DELETE_AN_EMAILS)
                .then()
                .log().body()
                .extract()
                .response();
    }
}
