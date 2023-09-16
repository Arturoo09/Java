package edu.ucam.hilossync;

import java.awt.EventQueue;
import edu.ucam.hilossync.gui.VentanaPrincipal;

public class Root {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}