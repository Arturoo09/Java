package edu.ucam.hilos;

import java.awt.EventQueue;
import edu.ucam.hilos.gui.Ventana;

public class Launcher {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
