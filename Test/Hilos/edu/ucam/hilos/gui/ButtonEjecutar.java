package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ucam.hilos.back.MiHilo;

public class ButtonEjecutar implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MiHilo hilo1 = new MiHilo(1);
		MiHilo hilo2 = new MiHilo(2);
		
		hilo1.start();
		hilo2.start();
	}
}
