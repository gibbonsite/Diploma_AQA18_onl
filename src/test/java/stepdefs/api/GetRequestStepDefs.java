package stepdefs.api;

import adapters.GetRequestsAdapters;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetRequestStepDefs {
    GetRequestsAdapters getRequestsAdapters = new GetRequestsAdapters();


    @When("authorization user want to get information from github")
    public void authorizationUserWantToGetInformationFromGithub() {
        getRequestsAdapters.authorizationUserWantToGetInformationFromGithub();
    }

    @Then("the requested data is returned")
    public void theRequestedDataIsReturned() {
        getRequestsAdapters.theRequestedDataIsReturned();
    }

    @When("authorization user want to get all information from github")
    public void authorizationUserWantToGetAllInformationFromGithub() {
        getRequestsAdapters.authorizationUserWantToGetAllInformationFromGithub();

    }

    @Then("the requested data info of all user is returned")
    public void theRequestedDataInfoOfAllUserIsReturned() {
        getRequestsAdapters.theRequestedDataAllUserIsReturned();
    }

    @When("authorization user want to get emojis information from github")
    public void authorizationUserWantToGetEmojisInformationFromGithub() {
        getRequestsAdapters.authorizationUserWantToGetEmojisInformationFromGithub();
    }

    @Then("the requested data emojis is returned")
    public void theRequestedDataEmojisIsReturned() {
        getRequestsAdapters.theRequestedDataOfEmojisIsReturned();
    }

    @When("authorization user want to get emojis with double access token")
    public void authorizationUserWantToGetEmojisWithDoubleAccessToken() {
        getRequestsAdapters.requestForEmojisWithDoubleToken();
    }

    @Then("the requester data return error unauthorization error")
    public void theRequesterDataReturnErrorUnauthorizationError() {
        getRequestsAdapters.theRequesterDataReturnErrorBadRequest();
    }

    @When("authorization user want to get information from github with wrong endpoint")
    public void authorizationUserWantToGetInformationFromGithubWithWrongEndpoint() {
        getRequestsAdapters.authorizationUserWantToGetInformationFromGithubWithWrongEndpoint();
    }

    @Then("the requester data return error not found error")
    public void theRequesterDataReturnErrorNotFoundError() {
        getRequestsAdapters.theRequesterDataReturnErrorNotFoundError();
    }
}
