package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;

import edu.ucam.practicafinaldad.gui.dialogs.AddNewClient;

public class AddNewClientButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		AddNewClient dialog = new AddNewClient();
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
	}
}
