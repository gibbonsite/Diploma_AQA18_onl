package apiSteps;

import adapters.Specification;
import configurationForApi.ReadProperties;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.*;

public class StepDefsForGetRequest {
    private Response response;


    @When("authorization user want to get information from github")
    public void authorizationUserWantToGetInformationFromGithub() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        RequestSpecification request = RestAssured.given();

        response = request.header("Authorization", "Bearer " + ReadProperties.token())
                .accept("application/vnd.github+json")
                .get((USER_URL + "/" + ReadProperties.username()))
                .then()
                .log().body()
                .extract().response();
    }

    @Then("the requested data is returned")
    public void theRequestedDataIsReturned() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @When("authorization user want to get all information from github")
    public void authorizationUserWantToGetAllInformationFromGithub() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        RequestSpecification request = RestAssured.given();

        response = request.header("Authorization", "Bearer " + ReadProperties.token())
                .accept("application/vnd.github+json")
                .get(USER_URL)
                .then()
                .log().body().extract().response();

    }

    @When("authorization user want to get emojis information from github")
    public void authorizationUserWantToGetEmojisInformationFromGithub() {
        RestAssured.baseURI = GITHUB;
        RequestSpecification request = RestAssured.given();

        response = request.header("Authorization", "Bearer " + ReadProperties.token())
                .accept("application/vnd.github+json")
                .get(GET_EMOJIS)
                .then()
                .log().body().extract().response();
    }

    @When("authorization user want to get emojis with wrong access token")
    public void authorizationUserWantToGetEmojisWithWrongAccessToken() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        RequestSpecification request = RestAssured.given();

        response = request.header("Authorization", "Bearer " + "fdsfdsfs")
                .accept("application/vnd.github+json")
                .get(GET_EMOJIS)
                .then()
                .log().body().extract().response();
    }

    @Then("the requester data return error unauthorization error")
    public void theRequesterDataReturnErrorUnauthorizationError() {
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_UNAUTHORIZED);
    }

    @When("authorization user want to get information from github with wrong endpoint")
    public void authorizationUserWantToGetInformationFromGithubWithWrongEndpoint() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        RequestSpecification request = RestAssured.given();

        response = request.header("Authorization", "Bearer " + ReadProperties.token())
                .accept("application/vnd.github+json")
                .get("//repo")
                .then()
                .log().body().extract().response();
    }

    @Then("the requester data return error not found error")
    public void theRequesterDataReturnErrorNotFoundError() {
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND);
    }
}
