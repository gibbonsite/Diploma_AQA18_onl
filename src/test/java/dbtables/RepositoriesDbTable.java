package dbtables;

import core.configuration.ReadProperties;
import core.services.DataBaseService;
import model.api.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoriesDbTable {
    private DataBaseService dbService;

    public RepositoriesDbTable(DataBaseService dbService) {
        this.dbService = dbService;
    }
    public void createRepositoryTable() {
        String createTableSQL = "Create table repositories " +
                "(id SERIAL PRIMARY KEY," +
                "    name TEXT (255)," +
                "    announcement TEXT(255)," +
                "    description TEXT(255)," +
                "    isPrivate BOOLEAN" +
                ");";
        dbService.executeSQL(createTableSQL);
        System.out.println("Table create");
    }
    public void addRepositoryToDb(Repository repository) {


        String insertRepoSQL = "INSERT INTO " + ReadProperties.getApiConfig().database() + ".repositories (" +
                "id, name, announcement, description, isPrivate)" +
                "VALUES ('" + repository.getId()
                + "', '" + repository.getName()
                + "', '" + repository.getAnnouncement()
                + "', '" + repository.getDescription()
                + "', " + repository.isIsPrivate() + ");";
        dbService.executeSQL(insertRepoSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.getApiConfig().database() + ".repositories";
        System.out.println("Table delete");
        dbService.executeSQL(dropTableSQL);
    }

    public Repository getRepository(int id) {
        String sql = "SELECT * FROM " + ReadProperties.getApiConfig().database() + ".repositories " +
                "WHERE id = " + id;
        ResultSet resultSet = dbService.executeQuery(sql);
        Repository repository = Repository.builder().build();
        try {
            while (resultSet.next()) {
                repository.setId(resultSet.getInt("id"));
                repository.setName(resultSet.getString("name"));
                repository.setAnnouncement(resultSet.getString("announcement"));
                repository.setDescription(resultSet.getString("description"));
                repository.setIsPrivate(resultSet.getBoolean("isPrivate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return repository;
    }
}
