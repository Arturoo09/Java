package edu.ucam.hilos.gui.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.back.HiloSimple;
import edu.ucam.hilos.gui.tabla.MiTabla;

public class BotonPararHilo extends BotonBase implements ActionListener {

	private JTable hiloTable;

	public BotonPararHilo(MiTabla tableModel, GestorHilos gestorHilos, JTable hiloTable) {
	    super(tableModel, gestorHilos);
	    this.hiloTable = hiloTable;
	}

	 @Override
	    public void actionPerformed(ActionEvent e) {
	        int selectedRow = hiloTable.getSelectedRow();
	        
	        if (selectedRow != -1) {
	            HiloSimple hiloSeleccionado = gestorHilos.getHiloAt(selectedRow);
	            gestorHilos.detenerHilo(hiloSeleccionado);
	        }
	    }
}