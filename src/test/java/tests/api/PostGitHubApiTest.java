package tests.api;

import adapters.Specifications;
import configurationForApi.ReadProperties;
import models.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.*;

public class PostGitHubApiTest {
    @Test(priority = 1)
    public void createRepositoryTest() {
        Repositories expectedRepositories = Repositories.builder()
                .announcement("Description for repo")
                .name("Test_Repo_1")
                .isPrivate(false)
                .build();

        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk201());
        given()
                .body(expectedRepositories)
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().body()
                .post(AUTHENTICATED_USER_REPO)
                .then()
                .log().all();
    }

    @Test(priority = 2)
    public void createdRepoIsAlreadyExist() {
        Repositories expectedRepositories = Repositories.builder()
                .announcement("Description for repo")
                .name("Test_Repo_1")
                .isPrivate(false)
                .build();


        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk422());
        given()
                .body(expectedRepositories)
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().body()
                .post(AUTHENTICATED_USER_REPO)
                .then()
                .log().all();
    }

    @Test(priority = 3)
    public void deleteRepoTest() {
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk204());
        given()
                .pathParams("owner", ReadProperties.username())
                .pathParams("repo", "Test_Repo_1")
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().all()
                .when()
                .delete(DELETE_REPO)
                .then().log().all();
    }

    @Test
    public void addFork(){
        Forks expectedForks = Forks.builder()
                .name("TestForksAdded")
                .build();

        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk202());
        given()
                .body(expectedForks)
                .when()
                .pathParams("owner", ReadProperties.username())
                .pathParams("repo", "Test_Repo_11231")
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().body()
                .post(CREATE_A_FORK)
                .then()
                .log().all();
    }
    @Test
    public void addEmails(){
        String[] emails = new String[1];
        emails[0] = "vshchatsko@gmail.com";


        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk201());
        given()
                .body(emails)
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().body()
                .post(ADD_AN_EMAILS)
                .then()
                .log().all();
    }

    @Test(dependsOnMethods = "addEmails")
    public void addEmailsAlreadyExist(){
        String[] emails = new String[1];
        emails[0] = "vshchatsko@gmail.com";


        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk422());
        given()
                .body(emails)
                .when()
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().body()
                .post(ADD_AN_EMAILS)
                .then()
                .log().all();
    }
    @Test
    public void deleteEmailTest() {
        String[] emails = new String[1];
        emails[0] = "vshchatsko@gmail.com";
        Specifications.installSpecification(Specifications.requestSpecification(GITHUB), Specifications.responseSpecOk204());
        given()
                .body(emails)
                .accept("application/vnd.github+json")
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .log().all()
                .when()
                .delete(DELETE_AN_EMAILS)
                .then().log().all();
    }
}
