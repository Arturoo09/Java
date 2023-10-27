package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.Manager;
import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;
import edu.ucam.practicafinaldad.gui.dialogs.AddNewClient;

public class CreateNewClientButton implements ActionListener {
	
	private AddNewClient addNewClient;
	private DatabaseManager dbManager;
	private Manager userManager;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JCheckBox chkbxIsAdmin;
	private String username;
	private String passwd;
	private int id;
	private int isAdmin;
	private String table = "users";
	private List<String> columns = Arrays.asList("id", "username", "password", "admin");
	private List<Object> values = new ArrayList<>();
	
	
	public CreateNewClientButton(AddNewClient addNewClient, JTextField txtUsername, JTextField txtPassword, JCheckBox chkbxIsAdmin) {
		this.addNewClient = addNewClient;
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
		
		if (chkbxIsAdmin.isSelected()) {
			isAdmin = 1;
		} else {
			isAdmin = 0;
		}
		
		try {
			this.id = this.userManager.generateID();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		values.add(id);
		values.add(username);
		values.add(passwd);
		values.add(isAdmin);
		
		try {
			this.dbManager.insert(table, columns, values);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		this.addNewClient.dispose();
	}

}
