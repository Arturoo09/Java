package edu.ucam.hilossinarray.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import edu.ucam.hilossinarray.back.Hilo1;
import edu.ucam.hilossinarray.back.Hilo2;
import edu.ucam.hilossinarray.back.NombresHilos;

public class BotonEjecutarUno implements ActionListener {

	private Hilo1 hilo1;
    private Hilo2 hilo2;
    private JComboBox<String> comboBox;
    private BotonParar botonParar;
    
    public BotonEjecutarUno(JComboBox<String> comboBox, Hilo1 hilo1, Hilo2 hilo2, BotonParar botonParar) {
        this.comboBox = comboBox;
        this.hilo1 = hilo1;
		this.hilo2 = hilo2;
		this.botonParar = botonParar;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedThread = (String) comboBox.getSelectedItem();
		
		if (selectedThread != null) {
			if (selectedThread.equals(NombresHilos.HILO_1.getNombreHilo())) {
				hilo1 = new Hilo1();
				botonParar.setHilo1(hilo1);
				hilo1.start();
			} else if (selectedThread.equals(NombresHilos.HILO_2.getNombreHilo())) {
				hilo2 = new Hilo2("working...");
				botonParar.setHilo2(hilo2);
				hilo2.start();
			}
		}
	}
	
	public Hilo1 getHilo1() {
        return hilo1;
    }

    public Hilo2 getHilo2() {
        return hilo2;
    }

}
