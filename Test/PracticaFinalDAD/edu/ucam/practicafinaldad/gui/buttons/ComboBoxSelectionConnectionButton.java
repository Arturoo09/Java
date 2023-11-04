package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;

public class ComboBoxSelectionConnectionButton implements ActionListener {
	
	private JComboBox<String> cbxConnections;
	private JTextField txtMail;
	private JTextField txtMailPswd;
	private Map<String, IMAPConnection> imapConnectionsMap;
	
	public ComboBoxSelectionConnectionButton(JComboBox<String> cbxConnections, JTextField txtMail,
			JTextField txtMailPswd, Map<String, IMAPConnection> imapConnectionsMap) {
		this.cbxConnections = cbxConnections;
		this.txtMail = txtMail;
		this.txtMailPswd = txtMailPswd;
		this.imapConnectionsMap = imapConnectionsMap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOption = (String) cbxConnections.getSelectedItem();
		if (selectedOption != null) {
			IMAPConnection connection = imapConnectionsMap.get(selectedOption);
			if (connection != null) {
				txtMail.setText(connection.getEmail());
				txtMailPswd.setText(connection.getPswdMail());
			}
		}
	}
}