package edu.ucam.practicafinaldad.back;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;

public class UserManager implements IUserManager{
	
	private DatabaseManager dbManager;
	private String table = "users";
	private String column = "id";
	
	public UserManager() {
		try {
            this.dbManager = new DatabaseManager();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	@Override
	public int generateID() throws SQLException {
	    // Obtener el máximo valor actual en la columna "id"
	    List<Map<String, Object>> lastIdList = this.dbManager.select(table, "MAX(" + column + ") as max_id", null);
	    
	    int lastId = 0;
	    
	    if (!lastIdList.isEmpty()) {
	    	String maxIdString = (String) lastIdList.get(0).get("max_id");
	    	if (maxIdString != null) {
	    	    lastId = Integer.parseInt(maxIdString);
	    	}
	    }
	    
	    // Generar un nuevo ID sumando 1 al máximo valor actual
	    return lastId + 1;
	}

	
	@Override
	public User getUser(String username, String password) throws SQLException {
	    String query = "SELECT * FROM users WHERE username=? AND password=?";
	    try (PreparedStatement statement = dbManager.getConnection().prepareStatement(query)) {
	        statement.setString(1, username);
	        statement.setString(2, password);

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                String id = resultSet.getString("id");
	                String dbUsername = resultSet.getString("username");
	                String dbPassword = resultSet.getString("password");
	                Boolean admin = resultSet.getBoolean("admin");
	                return new User(id, dbUsername, dbPassword, admin);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // Usuario no encontrado
	}

}
