package core.services;

import core.configuration.ReadProperties;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

@Log4j2
public class DataBaseService {
    Connection connection;

    public DataBaseService() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String urlDb = String.format("jdbc:%1$s://%2$s:%3$s/%4$s", ReadProperties.getApiConfig().dbType(),
                ReadProperties.getApiConfig().dbHost(), ReadProperties.getApiConfig().dbPort(),
                ReadProperties.getApiConfig().dbName());
        try {
            connection = DriverManager.getConnection(urlDb, ReadProperties.getAuthenticationConfig().dbUsername(),
                    ReadProperties.getAuthenticationConfig().dbPassword());
            log.info("DB connected successfully...");
        } catch (SQLException e) {
            closeConnection();
            log.error("Something went wrong while connecting to DB...");
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
        if (connection != null) {
            try {
                connection.close();
                log.info("Connection is closed");
            } catch (SQLException e) {
                log.error("Something went wrong while closing connection to DB...");
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
