package com.mytutos.java.designpatterns.singleton;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// todo create table at startup

@Component
public class DatabaseConnectionManager {

    private static DatabaseConnectionManager instance;
    private Connection connection;

    private DatabaseConnectionManager() {
        try {
            String url = "jdbc:mysql://localhost:3306/test_database";
            String username = "root";
            String password = "root";
            this.connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
