package edu.ucam.hilosprodcons;

import java.awt.EventQueue;

import edu.ucam.hilosprodcons.gui.MainWindow;

public class Root {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
