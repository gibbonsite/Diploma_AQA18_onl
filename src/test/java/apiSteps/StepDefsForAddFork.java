package apiSteps;

import adapters.ForkAdapter;
import configurationForApi.ReadProperties;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import models.Forks;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;

import static utils.Endpoints.*;

public class StepDefsForAddFork {
    ForkAdapter forkAdapter = new ForkAdapter();
    @When("user post data of repository to fork")
    public void userPostDataOfRepositoryToFork() {
        forkAdapter.createFork();

    }
    @Then("user get response from git hub about added fork")
    public void userGetResponseFromGitHubAboutAddedFork() {
        forkAdapter.checkAddedForkStatus();
    }
}
