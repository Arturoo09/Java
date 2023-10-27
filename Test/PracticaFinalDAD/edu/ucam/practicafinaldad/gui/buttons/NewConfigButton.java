package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.gui.dialogs.AddNewConfig;

public class NewConfigButton implements ActionListener{
	
	private User user;
	
	public NewConfigButton(User user) {
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AddNewConfig dialog = new AddNewConfig(user);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
	}

}
