package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.WindowConstants;

import edu.ucam.practicafinaldad.gui.dialogs.UsersManager;

public class OpenUsersManagerButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		UsersManager dialog = null;
		try {
			dialog = new UsersManager();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
	}
}
