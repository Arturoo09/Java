package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ComboBoxSelectionButton implements ActionListener {
	
	private JComboBox<String> cbxConnections;
	private JTextField txtHost;
	private JTextField txtPort;
	
	public ComboBoxSelectionButton(JComboBox<String> cbxConnections, JTextField txtHost, JTextField txtPort) {
		this.cbxConnections = cbxConnections;
		this.txtHost = txtHost;
		this.txtPort = txtPort;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOptions = (String) cbxConnections.getSelectedItem();
		if (selectedOptions != null) {
			if ("IMAP".equalsIgnoreCase(selectedOptions)) {
				txtHost.setText("imap.gamil.com");
				txtPort.setText("993");
			}else if ("SMTP".equalsIgnoreCase(selectedOptions)) {
				txtHost.setText("smtp.gamil.com");
				txtPort.setText("587");
			}else if ("Ninguna".equalsIgnoreCase(selectedOptions)) {
				txtHost.setText("");
				txtPort.setText("");
			}
		}
	}
}
