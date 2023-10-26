package edu.ucam.practicafinaldad.gui.dialogs;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.gui.buttons.CreateNewClientButton;

import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewClient extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JCheckBox chkbxIsAdmin;
	
	private CreateNewClientButton createNewClientButton;

	/**
	 * Create the ADD_CLIENT.
	 */
	public AddNewClient() {
		setResizable(false);
		setTitle("Create User");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setBounds(100, 100, 245, 236);
		
		JLabel lblNewUsername = new JLabel("Username");
		lblNewUsername.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblNewUsername.setBounds(30, 11, 74, 23);
		getContentPane().add(lblNewUsername);
		
		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblNewPassword.setBounds(30, 62, 74, 23);
		getContentPane().add(lblNewPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(30, 34, 171, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(30, 85, 171, 20);
		getContentPane().add(txtPassword);
		
		chkbxIsAdmin = new JCheckBox("ADMIN");
		chkbxIsAdmin.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		chkbxIsAdmin.setBounds(127, 112, 74, 23);
		getContentPane().add(chkbxIsAdmin);
		
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 142, 229, 56);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnCreate = new JButton("CREATE");
				btnCreate.setBackground(SystemColor.scrollbar);
				btnCreate.setBounds(15, 11, 97, 34);
				btnCreate.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
				btnCreate.setActionCommand("OK");
				buttonPane.add(btnCreate);
				getRootPane().setDefaultButton(btnCreate);
				
				createNewClientButton = new CreateNewClientButton(this, txtUsername, txtPassword, chkbxIsAdmin);
				btnCreate.addActionListener(createNewClientButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(SystemColor.scrollbar);
				cancelButton.setBounds(122, 12, 97, 32);
				cancelButton.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
