package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.Manager;
import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;
import edu.ucam.practicafinaldad.gui.Home;

public class LogInButton implements ActionListener{

	private JTextField txtUsername;
    private JPasswordField txtPassword;
    private DatabaseManager dbManager;
    private Manager userManager;
    private User user;
	
	public LogInButton(JTextField txtUsername, JPasswordField txtPassword){
		this.txtUsername = txtUsername;
		this.txtPassword = txtPassword;
		
		try {
            this.dbManager = new DatabaseManager();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		this.userManager = new Manager("users", "id");
		
	}
	
	//Funcion para pasar de char[] a String
	public String charToString(char[] char_text){
		return new String(char_text);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = txtUsername.getText();
		char[] passwordChars  = txtPassword.getPassword();
		String password = this.charToString(passwordChars);
		
		// Limpia la contraseña de la memoria
        Arrays.fill(passwordChars, ' ');
		
        try {
            boolean isValidCredentials = dbManager.checkCredentials(username, password);
            if (isValidCredentials) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    	try {
                    	    user = userManager.getUser(username, password);
                    	    if (user != null) {
                    	        // Autenticación exitosa, abre la ventana Home
                    	        EventQueue.invokeLater(new Runnable() {
                    	            public void run() {
                    	                try {
                    	                    Home frame = new Home(user);
                    	                    frame.setVisible(true);

                    	                    // Cierra el JFrame de inicio de sesión
                    	                    JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(txtUsername);
                    	                    loginFrame.dispose();
                    	                } catch (Exception ex) {
                    	                    ex.printStackTrace();
                    	                }
                    	            }
                    	        });
                    	    } else {
                    	        // Autenticación fallida, muestra un mensaje de error
                    	    	JOptionPane.showMessageDialog(null, "Las credenciales son inválidas.", "Error", JOptionPane.ERROR_MESSAGE);
                    	    	txtUsername.setText("");
                            	txtPassword.setText("");
                    	    }
                    	} catch (SQLException ex) {
                    	    ex.printStackTrace();
                    	}
                    }
                });
            } else {
            	// Abre un Warning Dialog
            	JOptionPane.showMessageDialog(null, "Las credenciales son inválidas.", "Error", JOptionPane.ERROR_MESSAGE);
            	txtUsername.setText("");
            	txtPassword.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
