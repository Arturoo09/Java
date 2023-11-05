package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.Manager;
import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;
import edu.ucam.practicafinaldad.gui.Table.UserTableModel;

public class CreateNewClientButton implements ActionListener {

	private DatabaseManager dbManager;
	private Manager userManager;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JCheckBox chkbxIsAdmin;
	private String username;
	private String passwd;
	private JTable userTable;
	private int id;
	private String id_str;
	private boolean isAdmin;
	private String table = "users";
	private List<String> columns = Arrays.asList("id", "username", "password", "admin");
	
	public CreateNewClientButton(JTable userTable, JTextField txtUsername, JTextField txtPassword, JCheckBox chkbxIsAdmin) {
		this.userTable = userTable;
		this.txtUsername = txtUsername;
		this.txtPassword = txtPassword;
		this.chkbxIsAdmin = chkbxIsAdmin;
		
		try {
			this.dbManager = new DatabaseManager();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.userManager = new Manager("users", "id");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		this.username = txtUsername.getText();
		this.passwd = txtPassword.getText();
		this.isAdmin = chkbxIsAdmin.isSelected();
		
		try {
            // Asegúrate de que generateID() devuelve un String
            this.id = this.userManager.generateID(); 
            this.id_str = Integer.toString(id);
            List<Object> values = Arrays.asList(id, username, passwd, isAdmin ? 1 : 0); // Ajustar para la base de datos
            
            this.dbManager.insert(table, columns, values);
            
            // Actualizar la tabla con el nuevo usuario
            User newUser = new User(id_str, username, passwd, isAdmin);
            ((UserTableModel) userTable.getModel()).addData(newUser);
            
		} catch (SQLException e1) {
            e1.printStackTrace();
        }
	}
		
}
