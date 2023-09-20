package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonPara implements ActionListener {
	private List<Thread> hilos;

	public ButtonPara(List<Thread> hilos) {
		this.hilos = hilos;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (hilos.isEmpty()) {
				System.out.println("Array vacia");
				return;
			}

			for (Thread hilo : hilos) {
				hilo.interrupt();
			}
			
			// PROBLEMA: AUNQUE SE INTERRUMPAN LOS HILOS, NO SE ELIMINAN.
			
		} catch (Exception e1) {
			System.out.println("Error...");
		}
	}
}
