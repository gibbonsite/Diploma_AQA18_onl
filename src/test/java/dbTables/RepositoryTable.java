package dbTables;


/*import com.github.dockerjava.api.model.Repository;
import configurationForApi.ReadProperties;
import models.Repositories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import configurationForApi.DataBaseService;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTable {
    Logger logger = LogManager.getLogger(RepositoryTable.class);
    private DataBaseService dbService;

    public RepositoryTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Creating Repository table");

        String createTableSQL = "Create table Repository " +
                "(   id                SERIAL PRIMARY KEY," +
                "    name              CHARACTER VARYING(255)," +
                "    description       CHARACTER VARYING(255)," +
                "    isPrivate         BOOLEAN" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Drop Repository table");
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.database() + ".Repository";
        dbService.executeSQL(dropTableSQL);
    }

    public void addRepository(Repositories repository) {
        logger.info("Adding Repository to the Repository table");
        String insertUserSQL = "INSERT INTO " + ReadProperties.database() + ".Repository (" +
                "name, description, isPrivate)" +
                "VALUES ('" + repository. + "', '" + repository.getDescription() + "', " +
                repository.isIsPrivate() + ");";
        dbService.executeSQL(insertUserSQL);
    }

    public Repositories getRepository(int id) {
        logger.info("Getting Repository by id from Repository table");
        String sql = "SELECT * FROM " + ReadProperties.database() + ".Repository " +
                "WHERE id = " + id;
        ResultSet rs = dbService.executeQuery(sql);
        Repository repository = Repository.builder().build();
        try {
            while (rs.next()) {
                repository.setName(rs.getString("name"));
                repository.setDescription(rs.getString("description"));
                repository.setIsPrivate(rs.getBoolean("isPrivate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return repositories;
    }
}*/

