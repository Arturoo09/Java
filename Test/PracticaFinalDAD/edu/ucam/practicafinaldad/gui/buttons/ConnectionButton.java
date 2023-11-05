package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import edu.ucam.practicafinaldad.back.TextFieldsManager;
import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.back.Threads.MailConnectionThread;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;

public class ConnectionButton implements ActionListener {
	
	private User user;
	private TextFieldsManager textFieldsManager;
	private EmailTableModel tableModel;
	private JProgressBar progressBar;
	private JLabel lblStatus;
	
	public ConnectionButton(User user, TextFieldsManager textFieldsManager, EmailTableModel tableModel, JProgressBar progressBar, JLabel lblStatus) {
		this.user = user;
		this.textFieldsManager = textFieldsManager;
		this.tableModel = tableModel;
		this.progressBar = progressBar;
		this.lblStatus = lblStatus;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (textFieldsManager.verifyTextFields()) {
			String host = textFieldsManager.getTxtHost();
			String port_str = textFieldsManager.getTxtPort();
			String email = textFieldsManager.getTxtMail();
			String amount_str = textFieldsManager.getTxtAmount();
			
			// Búsqueda de conexion
			IMAPConnection existingConnection = null;
            for (IMAPConnection conn : user.getConnections()) {
                if (conn.getEmail().equals(email)) {
                    existingConnection = conn;
                    break;
                }
            }
			
			// Si la conexión existe, utilizamos el correo electrónico y la contraseña de esa conexión
            if (existingConnection != null) {
    			int amount = Integer.parseInt(amount_str);
    			int port_int = Integer.parseInt(port_str);
    			
    			existingConnection.setHost(host);
    			existingConnection.setPort(port_int);
    			
    			MailConnectionThread connectionThread = new MailConnectionThread(existingConnection, tableModel, progressBar, lblStatus, amount);
    			connectionThread.start();
            }else {
            	JOptionPane.showMessageDialog(null, "No existe esta conexion para este usuario!!", "Error", JOptionPane.ERROR_MESSAGE);
            }
		}
	}
}
