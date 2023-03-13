package stepdefs.api;


import adapters.RepositoryAdapter;

import core.services.DataBaseService;
import dbtables.RepositoriesDbTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.response.Response;

import models.Repository;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class RepositoryStepDefs {
    protected DataBaseService dbService;
    protected RepositoriesDbTable repositoriesDbTable;
    protected RepositoryAdapter repositoryAdapter;

    public RepositoryStepDefs() {
        this.dbService = new DataBaseService();
        this.repositoriesDbTable = new RepositoriesDbTable(dbService);
        this.repositoryAdapter = new RepositoryAdapter();
    }

    Logger logger = LogManager.getLogger(AddForkStepDefs.class);

    @When("user add repository to database")
    public void userAddRepositoryToDatabase() {
        logger.info("Create repo table and add to database");
        repositoriesDbTable.dropTable();
        repositoriesDbTable.createRepositoryTable();
        Repository repository = Repository.builder()
                .id(1)
                .name("New diploma repo")
                .announcement("New repository")
                .description("This is repository for testing")
                .isPrivate(false)
                .build();
        repositoriesDbTable.addRepositoryToDb(repository);
    }

    @And("user post data to github api")
    public void userPostRepoDataToGithubApi() {
        repositoryAdapter.createRepository(repositoriesDbTable.getRepository(1));
    }

    @And("user check code status")
    public void userCheckCodeStatus() {
        repositoryAdapter.checkCreatedStatus();
    }

    @When("user get repo data to github api")
    public void userGetRepoDataToGithubApi() {
        repositoryAdapter.getRepo();
    }

    @Then("user get response from github about created repository")
    public void userGetRequestFromGithubAboutCreatedRepository() {
        repositoryAdapter.checkGetStatus();
    }

    @And("Delete repository")
    public void deleteRepository() {
        Response deleteResponse = repositoryAdapter.deleteRepo();
        Assert.assertEquals(deleteResponse.statusCode(), HttpStatus.SC_NO_CONTENT);
        repositoriesDbTable.dropTable();
        dbService.closeConnection();
    }
}
