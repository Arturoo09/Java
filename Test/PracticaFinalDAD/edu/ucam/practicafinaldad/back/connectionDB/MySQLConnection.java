package edu.ucam.practicafinaldad.back.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/practica_final_dad";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Root_69_";
    
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
