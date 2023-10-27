package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.Threads.MailConnectionThread;

public class ConnectionButton implements ActionListener {
	
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtMail;
	private JTextField txtMailPswd;
	
	public ConnectionButton(JTextField txtHost, JTextField txtPort, JTextField txtMail, JTextField txtMailPswd) {
		this.txtHost = txtHost;
		this.txtPort = txtPort;
		this.txtMail = txtMail;
		this.txtMailPswd = txtMailPswd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String host = txtHost.getText();
		String port = txtPort.getText();
		String email = txtMail.getText();
		String password = txtMailPswd.getText();
		
		int port_int = Integer.parseInt(port);
		
		MailConnectionThread connectionThread = new MailConnectionThread(host, port_int, email, password);
		connectionThread.start();
	}
}
