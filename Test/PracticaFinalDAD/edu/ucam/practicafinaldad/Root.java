package edu.ucam.practicafinaldad;
import java.awt.EventQueue;

import edu.ucam.practicafinaldad.gui.LogIn;

public class Root {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
