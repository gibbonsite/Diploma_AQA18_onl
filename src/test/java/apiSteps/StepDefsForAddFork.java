package apiSteps;

import adapters.ForkAdapter;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


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
