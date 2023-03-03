package apiSteps;

import adapters.EmailAdapter;
import adapters.RepositoryAdapter;
import adapters.Specification;
import configurationForApi.ReadProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;

import static utils.Endpoints.GITHUB;


public class StepDefsEmail {
    EmailAdapter emailAdapter = new EmailAdapter();
    Response response;

    @When("user post email address for github")
    public void userPostEmailAddressForGithub() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        emailAdapter.addEmailToGithub();
    }

    @Then("user get response from github about email address is added")
    public void userGetResponseFromGithubAboutEmailAddressIsAdded() {
        emailAdapter.responseStatusAddEmail();
    }

    @Then("user send get response to github")
    public void userGetResponseFromGithubAboutEmailIsAlreadyAdded() {
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));
        response = emailAdapter.getEmailsList();
    }

    @And("check get status")
    public void checkGetStatus() {
        Assert.assertEquals(response.statusCode(), 200);
    }

    @And("delete added email")
    public void deleteAddedEmail() {
        emailAdapter.deleteEmail();
    }
}
