package apiSteps;

import adapters.GetRequestsAdapters;
import adapters.Specification;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;
import static utils.Endpoints.*;

public class StepDefsForGetRequest {
    GetRequestsAdapters getRequestsAdapters = new GetRequestsAdapters();


    @When("authorization user want to get information from github")
    public void authorizationUserWantToGetInformationFromGithub() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
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

    @When("authorization user want to get emojis information from github")
    public void authorizationUserWantToGetEmojisInformationFromGithub() {
        getRequestsAdapters.authorizationUserWantToGetEmojisInformationFromGithub();
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
