package configurationForApi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DataBaseService {

    static final String DB_TYPE = "mysql";
    static final String DB_HOST = "sql7.freesqldatabase.com";
    static final String DB_PORT = "3306";
    static final String DB_NAME = "sql7603069";
    static final String DB_USER = "sql7603069";
    static final String DB_PASSWORD = "RH4TJEqpvX";
    Connection connection;

    Logger logger = LogManager.getLogger(DataBaseService.class);

    public DataBaseService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String urlDb = String.format("jdbc:%1$s://%2$s:%3$s/%4$s", DB_TYPE, DB_HOST,DB_PORT, DB_NAME);
        try {
            connection = DriverManager.getConnection(urlDb, DB_USER, DB_PASSWORD);
            logger.info("DB connected successfully...");
        } catch (SQLException e) {
            closeConnection();
            logger.info("Something went wrong...");
            throw new RuntimeException(e);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void executeSQL(String sql) {
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        if(connection != null){
            try {
                connection.close();
                System.out.println("Connection is closed");
            } catch (SQLException e) {
                System.out.println("Something went wrong...");
                throw new RuntimeException(e);
            }
        }
    }

    private Statement getStatement() {
        try {
            return this.connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
