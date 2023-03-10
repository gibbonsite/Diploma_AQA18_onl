package stepdefs.api;

import adapters.EmailAdapter;

import core.services.DataBaseService;
import dbtables.EmailDbTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailStepDefs {
    protected DataBaseService dbService;
    protected EmailDbTable emailDbTable;
    protected EmailAdapter emailAdapter;

    public EmailStepDefs() {
        this.dbService = new DataBaseService();
        this.emailDbTable = new EmailDbTable(dbService);
        this.emailAdapter = new EmailAdapter();
    }

    Logger logger = LogManager.getLogger(EmailStepDefs.class);

    @When("Add information for db email")
    public void addInformationForDbEmail() {
        logger.info("Add email table and add to data base");
        emailDbTable.dropTable();
        emailDbTable.createEmailTable();
        Email email = Email.builder()
                .email("vshchatsko@gmail.com")
                .id(1).build();
        emailDbTable.addEmailToDb(email);
    }

    @When("user post email address for github")
    public void userPostEmailAddressForGithub() {
        emailAdapter.addEmailToGithub(emailDbTable.getEmails());
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
        emailAdapter.deleteEmail(emailDbTable.getEmails());
        dbService.closeConnection();
    }
}
