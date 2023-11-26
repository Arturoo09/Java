package edu.ucam.practicafinaldad.back.connectionDB.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager implements IDatabaseManager{

	private Connection connection;
	
	public DatabaseManager() throws SQLException {
		this.connection = MySQLConnection.getConnection();
	}
	
	public boolean checkCredentials(String username, String password) throws SQLException {
	    // Usa placeholders en la consulta
	    String query = "SELECT COUNT(*) FROM users WHERE username=? AND PASSWORD=?";

	    try (PreparedStatement statement = this.connection.prepareStatement(query)) {
	        statement.setString(1, username);  // Establece el valor para el primer placeholder
	        statement.setString(2, password);  // Establece el valor para el segundo placeholder

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getInt(1) > 0;  // Devuelve 'true' si encontró al menos una coincidencia
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    return false;
	}
	
	public void ensureAdminUserExists() throws SQLException {
	    // Verifica si existe el usuario admin con la contraseña admin
	    if (!checkCredentials("admin", "admin")) {
	        // Si no existe, crea el usuario admin
	        List<String> columns = new ArrayList<>();
	        columns.add("id");
	        columns.add("username");
	        columns.add("password");
	        columns.add("admin");

	        List<Object> values = new ArrayList<>();
	        // Se asume que la ID debe ser única y se generará aleatoriamente o será fija para el usuario admin.
	        // Aquí se pone un ejemplo con un UUID aleatorio. Esto podría ser un valor fijo también.
	        values.add("0");
	        values.add("admin");
	        values.add("admin");
	        values.add(true); // suponiendo que el campo `admin` es un booleano que indica si es admin o no.

	        int result = insert("users", columns, values);

	        if (result > 0) {
	            System.out.println("El usuario admin ha sido creado con éxito.");
	        } else {
	            System.out.println("No se ha podido crear el usuario admin.");
	        }
	    } else {
	        System.out.println("El usuario admin ya existe.");
	    }
	}
	
	// Método para insertar datos
	@Override
	public int insert(String table, List<String> columns, List<Object> values) throws SQLException {
	    if (columns.size() != values.size()) {
	        throw new IllegalArgumentException("El número de columnas debe ser igual al número de valores.");
	    }
	    
	    StringBuilder columnBuilder = new StringBuilder();
	    StringBuilder valueBuilder = new StringBuilder();
	    
	    for (int i = 0; i < columns.size(); i++) {
	        if (i > 0) {
	            columnBuilder.append(", ");
	            valueBuilder.append(", ");
	        }
	        
	        columnBuilder.append(columns.get(i));
	        valueBuilder.append("?");
	    }
	    
	    String query = "INSERT INTO " + table + " (" + columnBuilder.toString() + ") VALUES (" + valueBuilder.toString() + ")";
	    
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        for (int i = 0; i < values.size(); i++) {
	            Object value = values.get(i);
	            
	            if (value instanceof String) {
	                statement.setString(i + 1, (String) value);
	            } else if (value instanceof Integer) {
	                statement.setInt(i + 1, (Integer) value);
	            } else if (value instanceof Double) {
	                statement.setDouble(i + 1, (Double) value);
	            } else if (value instanceof Boolean) {
	                statement.setBoolean(i + 1, (Boolean) value);
	            } else {
	                throw new IllegalArgumentException("Tipo de dato no compatible: " + value.getClass().getName());
	            }
	        }
	        
	        return statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}


	// Método para leer datos
	@Override
	public List<Map<String, Object>> select(String table, String columns, String Condition) throws SQLException {
	    List<Map<String, Object>> resultList = new ArrayList<>();

	    String query = "SELECT " + columns + " FROM " + table;
	    if (Condition != null && !Condition.isEmpty()) {
	        query += Condition;
	    }

	    try (PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery()) {

	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        while (resultSet.next()) {
	            Map<String, Object> row = new HashMap<>();
	            for (int i = 1; i <= columnCount; i++) {
	                row.put(metaData.getColumnName(i), resultSet.getObject(i));
	            }
	            resultList.add(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}

	
	// Método para actualizar datos
	@Override
	public int update(String table, String setValues, String whereCondition) throws SQLException {
		String query = "UPDATE " + table + " SET " + setValues;
        if (whereCondition != null && !whereCondition.isEmpty()) {
            query += " WHERE " + whereCondition;
        }
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
            return 0;
        }
	}

	// Método para eliminar datos
	@Override
	public int delete(String table, String whereCondition) throws SQLException {
		String query = "DELETE FROM " + table;
        if (whereCondition != null && !whereCondition.isEmpty()) {
            query += " WHERE " + whereCondition;
        }
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
            return 0;
        }
	}

	public Connection getConnection() {
		return connection;
	}
}
