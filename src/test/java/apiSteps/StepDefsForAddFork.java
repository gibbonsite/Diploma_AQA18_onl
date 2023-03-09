package apiSteps;


import adapters.ForkAdapter;

import configurationForApi.DataBaseService;

import dbTables.ForkDbTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import models.Fork;


public class StepDefsForAddFork {
    protected DataBaseService dbService;
    protected ForkDbTable forkDbTable;
    protected ForkAdapter forkAdapter;

    public StepDefsForAddFork() {
        this.dbService = new DataBaseService();
        this.forkDbTable = new ForkDbTable(dbService);
        this.forkAdapter = new ForkAdapter();
    }

    @When("add information for database forks")
    public void addInformationForDatabaseForks() {
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
