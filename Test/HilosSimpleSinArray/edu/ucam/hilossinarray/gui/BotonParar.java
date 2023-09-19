package edu.ucam.hilossinarray.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ucam.hilossinarray.back.Hilo1;
import edu.ucam.hilossinarray.back.Hilo2;

public class BotonParar implements ActionListener {
	
	private Hilo1 hilo1;
	private Hilo2 hilo2;

    public BotonParar() { }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (hilo1 != null)
            	hilo1.interrupt();
            
            if (hilo2 != null)
            	hilo2.interrupt();
            
        } catch (Exception e1) {
            System.out.println("Error...");
        }
    }

	public void setHilo1(Hilo1 hilo1) {
		this.hilo1 = hilo1;
	}

	public void setHilo2(Hilo2 hilo2) {
		this.hilo2 = hilo2;
	}

}
