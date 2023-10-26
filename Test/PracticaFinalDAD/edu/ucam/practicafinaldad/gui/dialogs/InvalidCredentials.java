package edu.ucam.practicafinaldad.gui.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvalidCredentials extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public InvalidCredentials() {
		setTitle("WARNING");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\34625\\Downloads\\invalid_credentials.png"));
		setBounds(100, 100, 297, 114);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInvalidCredentialsWarning = new JLabel("Warning Invalid Credentials");
			lblInvalidCredentialsWarning.setBounds(38, 14, 216, 17);
			lblInvalidCredentialsWarning.setFont(new Font("Hack Nerd Font Propo", Font.BOLD, 14));
			contentPanel.add(lblInvalidCredentialsWarning);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setBackground(SystemColor.scrollbar);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
