package edu.ucam.practicafinaldad.back;

import java.sql.SQLException;

public interface IManager {
	public int generateID() throws SQLException;
	public User getUser(String username, String password) throws SQLException;
}
