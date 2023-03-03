package adapters;

import configurationForApi.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Repositories;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;
import utils.Endpoints;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.AUTHENTICATED_USER_REPO;
import static utils.Endpoints.GET_REPO;

public class TestAdapter extends BaseAdapter{
    private static Response response;
    public void createRepo() {
        Map<String, Object> body = new HashMap<>();
        body.put("name", "TestRep");
        body.put("description", "Testtts");
        body.put("private", false);
        response = given()
                .when()
                .body(body)
                .post(AUTHENTICATED_USER_REPO)
                .then().log().all().extract().response();
    }
    public void getCreateRepoStatusCode(){
        assertEquals(response.getStatusCode(), 201);
    }

    public Repositories getRepo(String repo){

        return given()
                .pathParam("owner", ReadProperties.username())
                .pathParam("repo", "Testtts")
                .when()
                .log().uri()
                .get(GET_REPO)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Repositories.class, ObjectMapperType.GSON);

    }
    public void getRepoStatusCode()
    {
        assertEquals(response.getStatusCode(), 200);
    }
}
