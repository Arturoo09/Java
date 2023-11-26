package edu.ucam.practicafinaldad.back.connectionDB.MySQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDatabaseManager {

	public int insert(String table, List<String> columns, List<Object> values) throws SQLException;
    public List<Map<String, Object>> select(String table, String columns, String whereCondition) throws SQLException;
    int update(String table, String setValues, String whereCondition) throws SQLException;
    int delete(String table, String whereCondition) throws SQLException;
    
}
