package edu.ucam.practicafinaldad.back.Threads;

import javax.swing.JLabel;
import javax.swing.JTable;

import edu.ucam.practicafinaldad.back.Email;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;

public class DeleteMailThread extends Thread{
	
	private IMAPConnection imapConnection;
	private JLabel lblStatus;
	private Email email;
	private int row;
	private JTable table;
	
	public DeleteMailThread(IMAPConnection imapConnection, JLabel lblStatus, Email email, int row, JTable table) {
		this.imapConnection = imapConnection;
		this.lblStatus = lblStatus;
		this.email = email;
		this.row = row;
		this.table = table;
	}
	
	@Override
	public void run() {
		try {
			imapConnection.connect();
			
			imapConnection.login(imapConnection.getEmail(), imapConnection.getPswdMail());
			lblStatus.setText("[*] LOGIN SUCCESSFUL");
			
			imapConnection.selectMailbox("INBOX");
			lblStatus.setText("[*] SELECTING INBOX");
			
			imapConnection.deleteEmail(this.email.getEmailId());
			lblStatus.setText("[*] DELETING EMAIL");
			
			imapConnection.close();
			lblStatus.setText("[*] LOGOUT");
			
			((EmailTableModel) table.getModel()).removeRow(row);
		
		} catch (Exception e) {
            lblStatus.setText("HA SURGIDO UN ERROR ELIMINANDO EL EMAIL... ");
            e.printStackTrace();
        }
	}

}
