package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextField;
import edu.ucam.practicafinaldad.back.Manager;
import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;
import edu.ucam.practicafinaldad.gui.Home;
import edu.ucam.practicafinaldad.gui.dialogs.AddNewConfig;

public class AddNewConfigButton implements ActionListener {
	
	private DatabaseManager dbManager;
	private Manager userManager;
	private User user, user1;
	private Home home;
	
	private JTextField txtMail;
	private JTextField txtMailPassword;
	
	private String userMail;
	private String mailPswd;
	private int id;
	
	private String table = "user_imap";
	private List<String> columns = Arrays.asList("connection_id", "user_id", "email", "pswd_mail");
	private List<Object> values = new ArrayList<>();
	
	private AddNewConfig addNewConfig;
	
	public AddNewConfigButton(AddNewConfig addNewConfig, JTextField txtMail, JTextField txtMailPassword, User user, Home home) {
		this.addNewConfig = addNewConfig;
		this.user = user;
		this.home = home;
		this.txtMail = txtMail;
		this.txtMailPassword = txtMailPassword;
		
		try {
			this.dbManager = new DatabaseManager();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.userManager = new Manager("user_imap", "connection_id");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.userMail = txtMail.getText();
		this.mailPswd = txtMailPassword.getText();
		
		try {
			this.id = this.userManager.generateID();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		values.add(id);
		values.add(user.getId());
		values.add(userMail);
		values.add(mailPswd);
		
		try {
			this.dbManager.insert(table, columns, values);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		this.addNewConfig.dispose();
		home.dispose();
		
		try {
			user1 = userManager.getUser(user.getUsername(), user.getPassword());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
        Home frame = new Home(user1);
        frame.setVisible(true);
	}
}
