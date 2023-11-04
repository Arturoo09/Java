package edu.ucam.practicafinaldad.back;

import java.util.ArrayList;
import java.util.List;

import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;

public class User {
	
	private String id;
	private String username;
	private String password;
	private Boolean admin;
	private List<IMAPConnection> connections; 
	
	public User(String id, String username, String password, Boolean admin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.connections = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public List<IMAPConnection> getConnections() {
        return connections;
    }

    public void addImapConnection(IMAPConnection connection) {
        this.connections.add(connection);
    }
    
    @Override
    public String toString() {
        return "User{" +
               "id='" + id + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' + // Posiblemente quieras omitir esto por seguridad
               ", admin=" + admin +
               ", connections=" + connections +
               '}';
    }

}
