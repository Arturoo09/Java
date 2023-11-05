package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.Email;
import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.back.Threads.DeleteMailThread;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;

public class DeleteEmailButton implements ActionListener {
	
	private final JTable emailTable;
    private final EmailTableModel tableModel;
    private JTextField mail;
    private User user;
    private JLabel lblStatus;
    
    public DeleteEmailButton(JTable emailTable, EmailTableModel tableModel, JTextField mail, User user, JLabel lblStatus) {
        this.emailTable = emailTable;
        this.tableModel = tableModel;
        this.mail = mail;
        this.user = user;
        this.lblStatus = lblStatus;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int row = emailTable.getSelectedRow();
        if(row == -1) {
            // Mostrar algún mensaje de error al usuario
            return;
        }
		
		IMAPConnection existingConnection = null;
        for (IMAPConnection conn : user.getConnections()) {
            if (conn.getEmail().equals(mail.getText())) {
                existingConnection = conn;
                break;
            }
        }
        
        int selectedRow = emailTable.getSelectedRow();
        if (selectedRow >= 0) {
            Email selectedEmail = tableModel.getEmailAt(selectedRow);
            if (selectedEmail != null) {
            	DeleteMailThread deleteMailThread = new DeleteMailThread(existingConnection, lblStatus, selectedEmail, row, emailTable);
                deleteMailThread.start();
            }
        }  
	}
}
