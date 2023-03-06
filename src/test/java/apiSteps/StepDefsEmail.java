package apiSteps;

import adapters.EmailAdapter;

import baseEntitites.BaseCucumberTest;
import configurationForApi.DataBaseService;
import dbTables.EmailDbTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Email;

public class StepDefsEmail extends BaseCucumberTest {
    protected DataBaseService dbService;
    protected EmailDbTable emailDbTable;
    protected EmailAdapter emailAdapter;
    protected BaseCucumberTest baseCucumberTest;
    protected Email email;

    public StepDefsEmail() {
        this.dbService = new DataBaseService();
        this.emailDbTable = new EmailDbTable(dbService);
        this.emailAdapter = new EmailAdapter();
        this.baseCucumberTest = new BaseCucumberTest();
    }
    @When("user post email address for github")
    public void userPostEmailAddressForGithub() {
        emailDbTable.getEmails();
        emailAdapter.addEmailToGithub();
    }

    @Then("user get response from github about email address is added")
    public void userGetResponseFromGithubAboutEmailAddressIsAdded() {
        emailAdapter.responseStatusAddEmail();
    }

    @Then("user send get response to github")
    public void userGetResponseFromGithubAboutEmailIsAlreadyAdded() {
        emailAdapter.getEmailsList();
    }

    @And("check get status")
    public void checkGetStatus() {
        emailAdapter.responseGetStatusEmail();
    }

    @And("delete added email")
    public void deleteAddedEmail() {
        emailAdapter.deleteEmail();
    }


    @And("Add information for db email")
    public void addInformationForDbEmail() {
        emailDbTable.getEmails();

    }
}
