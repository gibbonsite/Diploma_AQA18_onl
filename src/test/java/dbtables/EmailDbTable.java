package dbtables;

import core.configuration.ReadProperties;
import core.services.DataBaseService;
import model.api.Email;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailDbTable {
    private DataBaseService dbService;

    public EmailDbTable(DataBaseService dbService) {
        this.dbService = dbService;
    }
    public void createEmailTable() {
        String createTableSQL = "Create table email " +
                "(id SERIAL PRIMARY KEY," +
                "    email TEXT(255)" +
                ");";
        dbService.executeSQL(createTableSQL);
        System.out.println("Table create");
    }
    public void addEmailToDb(Email email) {
        String insertEmailSQL = "INSERT INTO " + ReadProperties.getApiConfig().database() + ".email (" +
                "id, email)" +
                "VALUES ('" + email.getId() + "', '" + email.getEmail() + "');";
        dbService.executeSQL(insertEmailSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.getApiConfig().database() + ".email";
        System.out.println("Table delete");
        dbService.executeSQL(dropTableSQL);

    }

    public List getEmails() {
        ResultSet resultSet = dbService.executeQuery("select * from email");
        Email email = Email.builder().build();
        ArrayList<Email> emails = new ArrayList<>();
        try {
            while (resultSet.next()) {
                email.setId(resultSet.getInt("id"));
                email.setEmail(resultSet.getString("email"));
                emails.add(email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emails.stream().map(Email::getEmail).collect(Collectors.toList());
    }
}