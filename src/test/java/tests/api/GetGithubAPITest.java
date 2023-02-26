package tests.api;

import adapters.Specifications;


import configurationForApi.ReadProperties;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.*;

public class GetGithubAPITest {
    @Test
    public void getUserByUsername() {
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk200());
        given()
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .get(USER_URL + "/" + ReadProperties.username())
                .then()
                .log().all();
    }

    @Test
    public void getAllUsers() {
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk200());
        given()
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .get(USER_URL)
                .then()
                .log().all();
    }

    @Test
    public void getEmojis() {
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk200());
        given()
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .get(GET_EMOJIS)
                .then()
                .log().all();
    }
    @Test
    public void getEmojisWrong() {
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk401());
        given()
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + "lk;k;k;")
                .get(GET_EMOJIS)
                .then()
                .log().all();
    }
    @Test
    public void getAllUsersWrongEndpoint() {
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk404());
        given()
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .get( "/" +USER_URL)
                .then()
                .log().all();
    }
}

