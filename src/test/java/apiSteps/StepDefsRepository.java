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
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        repositoryAdapter.createRepository();
    }
    @And("user check code status")
    public void userCheckCodeStatus() {
        repositoryAdapter.checkCreatedStatus();
    }

    @When("user get repo data to github api")
    public void userGetRepoDataToGithubApi() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        getRepoResponse = repositoryAdapter.getRepo("Test", "DiplomaAqa18Onl");
    }
    @Then("user get response from github about created repository")
    public void userGetRequestFromGithubAboutCreatedRepository() {
        Assert.assertEquals(getRepoResponse.statusCode(), 200);
    }

    @And("Delete repository")
    public void deleteRepository() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        Response deleteResponse = repositoryAdapter.deleteRepo();
        Assert.assertEquals(deleteResponse.statusCode(), 204);
    }
}
