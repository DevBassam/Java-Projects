package org.example;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DbConnection {

    private static final DbConnection instance = new DbConnection();
    private Connection connection;

    private DbConnection() {
        initConnection();
    }

    private void initConnection() {
        Properties propertiesFile = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/LibraryDB.properties");
            propertiesFile.load(inputStream);
            connection = DriverManager.getConnection(propertiesFile.getProperty("url"),
                    propertiesFile.getProperty("username"),
                    propertiesFile.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DbConnection getInstance() {
        return instance;
    }

    public Connection getConnection() {
        try {
            // Check if the connection is closed and reopen it if necessary
            if (connection == null || connection.isClosed()) {
                initConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
