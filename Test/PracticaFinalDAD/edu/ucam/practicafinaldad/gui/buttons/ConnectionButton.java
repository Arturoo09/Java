package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import edu.ucam.practicafinaldad.back.TextFieldsManager;
import edu.ucam.practicafinaldad.back.Threads.MailConnectionThread;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;

public class ConnectionButton implements ActionListener {
	
	private TextFieldsManager textFieldsManager;
	private EmailTableModel tableModel;
	private JProgressBar progressBar;
	private JLabel lblStatus;
	
	public ConnectionButton(TextFieldsManager textFieldsManager, EmailTableModel tableModel, JProgressBar progressBar, JLabel lblStatus) {
		this.textFieldsManager = textFieldsManager;
		this.tableModel = tableModel;
		this.progressBar = progressBar;
		this.lblStatus = lblStatus;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (textFieldsManager.verifyTextFields()) {
			String host = textFieldsManager.getTxtHost();
			String port = textFieldsManager.getTxtPort();
			String email = textFieldsManager.getTxtMail();
			String password = textFieldsManager.getTxtMailPswd();
			String amount_str = textFieldsManager.getTxtAmount();
			
			int port_int = Integer.parseInt(port);
			int amount = Integer.parseInt(amount_str);
			
			MailConnectionThread connectionThread = new MailConnectionThread(host, port_int, email, password, tableModel, progressBar, lblStatus, amount);
			connectionThread.start();
		}
	}
}
