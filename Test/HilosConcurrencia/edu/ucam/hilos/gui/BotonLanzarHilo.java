package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import edu.ucam.hilos.back.Contador;
import edu.ucam.hilos.back.HiloSimple;

public class BotonLanzarHilo implements ActionListener {
	
	private HiloSimple hilo;
	private Contador cont;
	private DefaultTableModel tableModel;
	
	public BotonLanzarHilo(HiloSimple hilo, Contador cont, DefaultTableModel tableModel) {
		this.hilo = hilo;
		this.setCont(cont);
		this.tableModel = tableModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		hilo.start();
		tableModel.addRow(new Object[]{Thread.currentThread().getName(), hilo.getContador().getContador()});
	}

	public Contador getCont() {
		return cont;
	}

	public void setCont(Contador cont) {
		this.cont = cont;
	}

}
