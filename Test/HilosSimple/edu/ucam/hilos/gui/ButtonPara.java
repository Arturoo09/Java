package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

public class ButtonPara implements ActionListener {
	private List<Thread> hilos;
	private JComboBox<Thread> comboBox;

	public ButtonPara(List<Thread> hilos, JComboBox<Thread> comboBox) {
		this.hilos = hilos;
		this.comboBox = comboBox;
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
				comboBox.removeItem(hilo);
			}
			
		} catch (Exception e1) {
			System.out.println("Error...");
		}
	}
}
