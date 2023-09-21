package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;

import edu.ucam.hilos.back.MiHilo;
import edu.ucam.hilos.back.MiHilo2;
import edu.ucam.hilos.back.NombreHilos;

public class ButtonEjecutarUno implements ActionListener {
	
	private MiHilo hilo1;
    private MiHilo2 hilo2;
    private JComboBox<String> comboBox;
    private JComboBox<Thread> comboBox1;
	private List<Thread> hilos;
    
    public ButtonEjecutarUno(JComboBox<String> comboBox, List<Thread> hilos, JComboBox<Thread> comboBox1) {
        this.comboBox = comboBox;
        this.hilos = hilos;
        this.comboBox1 = comboBox1;
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedThread = (String) comboBox.getSelectedItem();
		
		if (selectedThread != null) {
			if (selectedThread.equals(NombreHilos.HILO_1.getNombreHilo())) {
				hilo1 = new MiHilo();
				hilo1.start();
				hilos.add(hilo1);
				comboBox1.addItem(hilo1);
			} else if (selectedThread.equals(NombreHilos.HILO_2.getNombreHilo())) {
				hilo2 = new MiHilo2("Studying...");
				hilo2.start();
				hilos.add(hilo2);
				comboBox1.addItem(hilo2);
			}
		}
		
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
