package edu.ucam.practicafinaldad.gui.dialogs;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.gui.buttons.AddNewConfigButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewConfig extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMail;
	private JTextField txtMailPswd;
	
	private AddNewConfigButton addNewConfigButton;

	/**
	 * Create the AddNewConfig.
	 */
	public AddNewConfig(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Imágenes\\logoDAD.png"));
		setTitle("NEW CONFIG");
		setBounds(100, 100, 216, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblMail.setBounds(10, 11, 74, 23);
		contentPanel.add(lblMail);
		
		JLabel lblMailPassword = new JLabel("Password");
		lblMailPassword.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		lblMailPassword.setBounds(10, 62, 74, 23);
		contentPanel.add(lblMailPassword);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(10, 34, 171, 20);
		contentPanel.add(txtMail);
		
		txtMailPswd = new JTextField();
		txtMailPswd.setColumns(10);
		txtMailPswd.setBounds(10, 85, 171, 20);
		contentPanel.add(txtMailPswd);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(null);
		buttonPane.setBounds(10, 116, 180, 56);
		contentPanel.add(buttonPane);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		btnAdd.setBackground(SystemColor.scrollbar);
		btnAdd.setActionCommand("OK");
		btnAdd.setBounds(0, 11, 83, 34);
		buttonPane.add(btnAdd);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
		cancelButton.setBackground(SystemColor.scrollbar);
		cancelButton.setActionCommand("Cancel");
		cancelButton.setBounds(93, 11, 87, 34);
		buttonPane.add(cancelButton);
		
		addNewConfigButton = new AddNewConfigButton(this, txtMail, txtMailPswd, user);
		btnAdd.addActionListener(addNewConfigButton);
	}
}
