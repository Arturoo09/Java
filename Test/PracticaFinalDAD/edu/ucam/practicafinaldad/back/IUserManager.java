package edu.ucam.practicafinaldad.back;

import java.sql.SQLException;

public interface IUserManager {
	public int generateID() throws SQLException;
	public User getUser(String username, String password) throws SQLException;
}
