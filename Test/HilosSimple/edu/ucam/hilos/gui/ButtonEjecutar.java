package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import edu.ucam.hilos.back.MiHilo;
import edu.ucam.hilos.back.MiHilo2;

public class ButtonEjecutar implements ActionListener {
	private MiHilo hilo1;
	private MiHilo2 hilo2;
	private List<Thread> hilos;
	private JComboBox<Thread> comboBoxArray;
	
	public ButtonEjecutar(List<Thread> hilos, JComboBox<Thread> comboBoxArray) {
		this.hilos = hilos;
		this.comboBoxArray = comboBoxArray;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		hilo1 = new MiHilo();
		hilo2 = new MiHilo2("working...");
		
		hilos.add(hilo1);
		hilos.add(hilo2);
		
		comboBoxArray.addItem(hilo1);
		comboBoxArray.addItem(hilo2);
		
		hilo1.start();
		hilo2.start();
	}
	
	public List<Thread> getHilos() {
        return hilos;
    }
	
	public MiHilo getHilo1() {
        return hilo1;
    }

    public MiHilo2 getHilo2() {
        return hilo2;
    }
}
