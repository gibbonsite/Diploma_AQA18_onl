package apiSteps;

import adapters.EmailAdapter;
import adapters.Specification;
import configurationForApi.DataBaseService;
import dbTables.EmailDbTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import models.Email;

import static utils.Endpoints.GITHUB;

public class Hook {
    protected DataBaseService dbService;
    protected EmailDbTable emailDbTable;
    protected Email email;

    public Hook() {
        this.dbService = new DataBaseService();
        this.emailDbTable = new EmailDbTable(dbService);
    }


    @Before(order = 0)
    public void setUp() {
        emailDbTable.dropTable();
        emailDbTable.createEmailTable();
        email = Email.builder()
                .email("vshchatsko@gmail.com")
                .id(1)
                .build();
        emailDbTable.addEmailToDb(email);
        System.out.println("Api start");
        Specification.installRequestSpecification(Specification.requestSpecification(GITHUB));

    }

    @After
    public void tearDown() {
        System.out.println("api end");
        dbService.closeConnection();
    }
}
