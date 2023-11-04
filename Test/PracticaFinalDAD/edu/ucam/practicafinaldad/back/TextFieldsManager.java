package edu.ucam.practicafinaldad.back;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldsManager {
	
	private JTextField txtHost;
	private JTextField txtPort;
	private JTextField txtMail;
	private JTextField txtMailPswd;
	private JTextField txtAmount;
	
	public TextFieldsManager(JTextField txtHost, JTextField txtPort, JTextField txtMail, JTextField txtMailPswd,
			JTextField txtAmount) {
		this.txtHost = txtHost;
		this.txtPort = txtPort;
		this.txtMail = txtMail;
		this.txtMailPswd = txtMailPswd;
		this.txtAmount = txtAmount;
	}

	public String getTxtHost() {
		return txtHost.getText();
	}

	public String getTxtPort() {
		return txtPort.getText();
	}

	public String getTxtMail() {
		return txtMail.getText();
	}

	public String getTxtMailPswd() {
		return txtMailPswd.getText();
	}

	public String getTxtAmount() {
		return txtAmount.getText();
	}
	
    // Método para verificar los campos de texto y mostrar un diálogo si alguno está vacío
    public boolean verifyTextFields() {
        if (txtHost.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Host' está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            txtHost.requestFocus();
            return false;
        }
        if (txtPort.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Port' está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            txtPort.requestFocus();
            return false;
        }
        if (txtMail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Mail' está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            txtMail.requestFocus();
            return false;
        }
        if (txtMailPswd.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Password' está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            txtMailPswd.requestFocus();
            return false;
        }
        if (txtAmount.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo 'Amount' está vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            txtAmount.requestFocus();
            return false;
        }
        
        return true;
    }
}
