package apiSteps;

import adapters.RepositoryAdapter;


import adapters.Specification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;

import org.testng.Assert;

import static utils.Endpoints.GITHUB;


public class StepDefsRepository {
    private static Response getRepoResponse;
    RepositoryAdapter repositoryAdapter = new RepositoryAdapter();

    @When("user post data to github api")
    public void userPostRepoDataToGithubApi() {
        repositoryAdapter.createRepository();
    }
    @And("user check code status")
    public void userCheckCodeStatus() {
        repositoryAdapter.checkCreatedStatus();
    }

    @When("user get repo data to github api")
    public void userGetRepoDataToGithubApi() {

        repositoryAdapter.getRepo("Test", "DiplomaAqa18Onl");
    }
    @Then("user get response from github about created repository")
    public void userGetRequestFromGithubAboutCreatedRepository() {
        repositoryAdapter.checkGetStatus();
    }

    @And("Delete repository")
    public void deleteRepository() {
        Response deleteResponse = repositoryAdapter.deleteRepo();
        Assert.assertEquals(deleteResponse.statusCode(), 204);
    }
}
