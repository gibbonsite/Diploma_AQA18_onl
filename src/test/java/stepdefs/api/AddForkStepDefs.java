package stepdefs.api;


import adapters.ForkAdapter;

import core.services.DataBaseService;
import dbtables.ForkDbTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import models.Fork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddForkStepDefs {
    protected DataBaseService dbService;
    protected ForkDbTable forkDbTable;
    protected ForkAdapter forkAdapter;

    public AddForkStepDefs() {
        this.dbService = new DataBaseService();
        this.forkDbTable = new ForkDbTable(dbService);
        this.forkAdapter = new ForkAdapter();
    }

    Logger logger = LogManager.getLogger(AddForkStepDefs.class);

    @When("add information for database forks")
    public void addInformationForDatabaseForks() {
        logger.info("Create fork table and add to data base");
        forkDbTable.dropTable();
        forkDbTable.createForkTable();
        Fork fork = Fork.builder()
                .name("New diploma repo fork")
                .id(1).build();
        forkDbTable.addForkToDb(fork);
    }

    @When("user post data of repository to fork")
    public void userPostDataOfRepositoryToFork() {
        forkAdapter.createFork(forkDbTable.getFork(1));
    }

    @Then("user get response from git hub about added fork")
    public void userGetResponseFromGitHubAboutAddedFork() {
        forkAdapter.checkAddedForkStatus();
        dbService.closeConnection();
    }
}
