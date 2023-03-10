package dbtables;

import core.configuration.ReadProperties;
import core.services.DataBaseService;
import lombok.extern.log4j.Log4j2;
import models.Fork;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class ForkDbTable {
    private DataBaseService dbService;

    public ForkDbTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createForkTable() {
        String createTableSQL = "Create table forks " +
                "(id SERIAL PRIMARY KEY," +
                "    name TEXT(255)" +
                ");";
        dbService.executeSQL(createTableSQL);
        log.info("Table created");
    }

    public void addForkToDb(Fork forks) {
        String insertForkSQL = "INSERT INTO " + ReadProperties.getApiConfig().dbName() + ".forks (" +
                "id, name)" +
                "VALUES ('" + forks.getId() + "', '" + forks.getName() + "');";
        dbService.executeSQL(insertForkSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.getApiConfig().dbName() + ".forks";
        dbService.executeSQL(dropTableSQL);
        log.info("Table deleted");
    }

    public Fork getFork(int id) {
        String sql = "SELECT * FROM " + ReadProperties.getApiConfig().dbName() + ".forks " +
                "WHERE id = " + id;
        ResultSet resultSet = dbService.executeQuery(sql);
        Fork forks = Fork.builder().build();
        try {
            while (resultSet.next()) {
                forks.setId(resultSet.getInt("id"));
                forks.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return forks;
    }
}
