package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class ButtonPararUno implements ActionListener {
	private JComboBox<Thread> comboBox;

	public ButtonPararUno(JComboBox<Thread> comboBox) {
		this.comboBox = comboBox;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread selectedThread = (Thread) comboBox.getSelectedItem();
		
		if (selectedThread != null) {
            if (selectedThread.isAlive()) {
                selectedThread.interrupt();
                comboBox.removeItem(selectedThread);
            } else {
                System.out.println("El hilo seleccionado ya ha terminado.");
            }
        }
		
	}

}
