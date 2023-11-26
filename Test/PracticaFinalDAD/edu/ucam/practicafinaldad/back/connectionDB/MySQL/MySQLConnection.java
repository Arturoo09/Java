package edu.ucam.practicafinaldad.back.connectionDB.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	private static final String JDBC_URL = "jdbc:mysql://us-east.connect.psdb.cloud/dad_database";
    private static final String JDBC_USER = "hh7svrsxx6awmvprhqtf";
    private static final String JDBC_PASSWORD = "pscale_pw_MHmXsjKBL8F2LO9PfKtZB7Dxgv3C9IQcSflfv95MHz7";
    
    private Connection connection;
    
    private MySQLConnection() {
        try {
             this.connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al establecer la conexión con la base de datos", e);
        }
    }
    
    // Singleton instance
    private static MySQLConnection instance = null;
    
    public static Connection getConnection() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance.connection;
    }
}
