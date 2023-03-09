package dbTables;

import configurationForApi.DataBaseService;
import configurationForApi.ReadProperties;
import models.Fork;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        System.out.println("Table create");
    }
    public void addForkToDb(Fork forks) {
        String insertForkSQL = "INSERT INTO " + ReadProperties.database() + ".forks (" +
                "id, name)" +
                "VALUES ('" + forks.getId() + "', '" + forks.getName() + "');";
        dbService.executeSQL(insertForkSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.database() + ".forks";
        System.out.println("Table delete");
        dbService.executeSQL(dropTableSQL);

    }

    public Fork getFork(int id) {
        String sql = "SELECT * FROM " + ReadProperties.database() + ".forks " +
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
