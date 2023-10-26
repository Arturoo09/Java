package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ucam.practicafinaldad.gui.Home;

public class NewConfigButton implements ActionListener{
	
	private Home home;
	
	
	public NewConfigButton(Home home) {
		this.home = home;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		home.showConnectionFields(true);
	}

}
