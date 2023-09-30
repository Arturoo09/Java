package edu.ucam.hilos.gui.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.gui.tabla.MiTabla;

public class BotonPararTodos extends BotonBase implements ActionListener {

	public BotonPararTodos(MiTabla tableModel, GestorHilos gestorHilos) {
		super(tableModel, gestorHilos);
	}

	 @Override
	public void actionPerformed(ActionEvent e) {
		gestorHilos.detenerTodos();
	}
}
