package edu.ucam.practicafinaldad.back;

public class User {
	
	private String id;
	private String username;
	private String password;
	private Boolean admin;
	
	public User(String id, String username, String password, Boolean admin) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
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
}
