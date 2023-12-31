package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.gui.Home;
import edu.ucam.practicafinaldad.gui.dialogs.AddNewConfig;

public class NewConfigButton implements ActionListener{
	
	private User user;
	private Home home;
	
	public NewConfigButton(User user, Home home) {
		this.user = user;
		this.home = home;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AddNewConfig dialog = new AddNewConfig(user, home);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
	}

}
