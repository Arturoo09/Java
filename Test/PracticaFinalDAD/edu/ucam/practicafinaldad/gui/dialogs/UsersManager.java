package edu.ucam.practicafinaldad.gui.dialogs;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;
import edu.ucam.practicafinaldad.gui.Table.UserTableModel;
import edu.ucam.practicafinaldad.gui.buttons.CreateNewClientButton;
import edu.ucam.practicafinaldad.gui.buttons.DeleteUserButton;
import edu.ucam.practicafinaldad.gui.buttons.UpdateUserButton;

import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UsersManager extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JCheckBox chkbxIsAdmin;
	private JButton btnCreate;
	private JButton btnDelete;
	
	private CreateNewClientButton createNewClientButton;
	private DeleteUserButton deleteUserButton;
	private UpdateUserButton updateUserButton;
	private JTable usersTable;
    private UserTableModel tableModel;
    private JButton btnSave;

	/**
	 * Create the ADD_CLIENT.
	 */
	public UsersManager() throws SQLException {
		setResizable(false);
		setTitle("USERS MANAGER");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setBounds(100, 100, 477, 331);
		
		JLabel lblNewUsername = new JLabel("Username");
		lblNewUsername.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblNewUsername.setBounds(271, 11, 74, 23);
		getContentPane().add(lblNewUsername);
		
		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblNewPassword.setBounds(271, 62, 74, 23);
		getContentPane().add(lblNewPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(271, 34, 171, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(271, 85, 171, 20);
		getContentPane().add(txtPassword);
		
		List<User> userList = this.getAllUsers();
		tableModel = new UserTableModel(userList);	
		
		usersTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(usersTable);
		scrollPane.setBounds(10, 11, 251, 270);
		getContentPane().add(scrollPane);
		
		usersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && usersTable.getSelectedRow() != -1) {
                    // Suponiendo que la primera columna es el username, la segunda la contraseña y la tercera si es admin
                    txtUsername.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString());
                    txtPassword.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 2).toString());
                    chkbxIsAdmin.setSelected((Boolean) usersTable.getValueAt(usersTable.getSelectedRow(), 3));
                    
                }
            }
        });

        scrollPane.setViewportView(usersTable);
		
		chkbxIsAdmin = new JCheckBox("ADMIN");
		chkbxIsAdmin.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		chkbxIsAdmin.setBounds(281, 112, 74, 23);
		getContentPane().add(chkbxIsAdmin);
		
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(263, 180, 198, 112);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				btnCreate = new JButton("CREATE");
				btnCreate.setBackground(SystemColor.scrollbar);
				btnCreate.setBounds(9, 22, 179, 34);
				btnCreate.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
				btnCreate.setActionCommand("OK");
				buttonPane.add(btnCreate);
				getRootPane().setDefaultButton(btnCreate);
				
				createNewClientButton = new CreateNewClientButton(usersTable, txtUsername, txtPassword, chkbxIsAdmin);
				btnCreate.addActionListener(createNewClientButton);
				
				btnDelete = new JButton("DELETE");
				btnDelete.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
				btnDelete.setBackground(SystemColor.scrollbar);
				btnDelete.setActionCommand("OK");
				btnDelete.setBounds(98, 67, 90, 34);
				buttonPane.add(btnDelete);
				
				deleteUserButton = new DeleteUserButton(usersTable, txtUsername, txtPassword, chkbxIsAdmin);
				btnDelete.addActionListener(deleteUserButton);
				
				btnSave = new JButton("SAVE");
				btnSave.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
				btnSave.setBackground(SystemColor.scrollbar);
				btnSave.setActionCommand("OK");
				btnSave.setBounds(9, 67, 79, 34);
				buttonPane.add(btnSave);
				
				updateUserButton = new UpdateUserButton(usersTable, txtUsername, txtPassword, chkbxIsAdmin);
				btnSave.addActionListener(updateUserButton);
			}	
		}
	}
	
	public List<User> getAllUsers() throws SQLException {
	    List<User> users = new ArrayList<>();
	    DatabaseManager dbManager = new DatabaseManager(); // Asegúrate de manejar SQLExceptions apropiadamente
	    
	    try {
	        // Utiliza el método 'select' de DatabaseManager para obtener los usuarios
	        List<Map<String, Object>> resultList = dbManager.select("users", "*", "");
	        
	        // Itera a través del resultado y crea objetos User
	        for (Map<String, Object> row : resultList) {
	            String id = (String) row.get("id");
	            String username = (String) row.get("username");
	            String password = (String) row.get("password");
	            boolean isAdmin = (Boolean) row.get("admin");
	            users.add(new User(id, username, password, isAdmin));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return users;
	}
}
