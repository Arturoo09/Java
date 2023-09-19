package edu.ucam.hilossinarray.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ucam.hilossinarray.back.Hilo1;
import edu.ucam.hilossinarray.back.Hilo2;

public class BotonEjecutarTodos implements ActionListener {

	private Hilo1 hilo1;
	private Hilo2 hilo2;
	private BotonParar botonParar;
	
	public BotonEjecutarTodos(Hilo1 hilo1, Hilo2 hilo2, BotonParar botonParar) {
		this.hilo1 = hilo1;
		this.hilo2 = hilo2;
		this.botonParar = botonParar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		hilo1 = new Hilo1();
		hilo2 = new Hilo2("working...");
		
		botonParar.setHilo1(hilo1);
		botonParar.setHilo2(hilo2);
		
		hilo1.start();
		hilo2.start();
	}
	
	public Hilo1 getHilo1() {
        return hilo1;
    }

    public Hilo2 getHilo2() {
        return hilo2;
    }

}
