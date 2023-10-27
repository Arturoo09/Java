package edu.ucam.practicafinaldad.back;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;

public class Manager implements IManager{
	
	private DatabaseManager dbManager;
	private String table;
	private String column;
	
	public Manager(String table, String column) {
		try {
            this.dbManager = new DatabaseManager();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		this.table = table;
		this.column = column;
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
	    String userQuery = "SELECT * FROM users WHERE username=? AND password=?";
	    User user = null;
	    try (PreparedStatement statement = dbManager.getConnection().prepareStatement(userQuery)) {
	        statement.setString(1, username);
	        statement.setString(2, password);

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                String id = resultSet.getString("id");
	                String dbUsername = resultSet.getString("username");
	                String dbPassword = resultSet.getString("password");
	                Boolean admin = resultSet.getBoolean("admin");
	                user = new User(id, dbUsername, dbPassword, admin);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    if (user != null) {
	        String imapQuery = "SELECT * FROM user_imap WHERE user_id=?";
	        try (PreparedStatement statement = dbManager.getConnection().prepareStatement(imapQuery)) {
	            statement.setString(1, user.getId());
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    int imapId = resultSet.getInt("connection_id");
	                    String email = resultSet.getString("email");
	                    String pswdMail = resultSet.getString("pswd_mail");
	                    IMAPConnection imapConnection = new IMAPConnection(imapId, user.getId(), email, pswdMail);
	                    user.addImapConnection(imapConnection);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return user;
	}
}
