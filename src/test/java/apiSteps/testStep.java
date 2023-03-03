package apiSteps;

import adapters.Specification;
import adapters.TestAdapter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.Repositories;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utils.Endpoints.GITHUB;

public class testStep {
    private static Response response;
    Repositories expectedRepo;
    TestAdapter testAdapter = new TestAdapter();
    @Given("Authorized user")
    public void authorizedUser() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
    }

    @When("create repos send Post request and get response")
    public void createReposSendPostRequestAndGetResponse() {
        TestAdapter testAdapter = new TestAdapter();
        testAdapter.createRepo();
    }

    @When("User send GET request about repository")
    public void userSendGETRequestAboutRepository() {
        Repositories actualRepo = testAdapter.getRepo(expectedRepo.getName());
        Assert.assertEquals(actualRepo, expectedRepo);
    }


}
