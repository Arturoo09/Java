package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import edu.ucam.hilos.back.Contador;
import edu.ucam.hilos.back.HiloSimple;

public class BotonLanzarHilo implements ActionListener {
	
	private List<EventListener> listeners = new ArrayList<>();
	
	private HiloSimple hilo;
	private Contador contador;
	private DefaultTableModel tableModel;
	
	public BotonLanzarHilo(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		contador = new Contador();
	    tableModel.addRow(new Object[]{ "Hilo-" + (tableModel.getRowCount() + 1), contador.getContador() });
	    int rowIndex = tableModel.getRowCount() - 1;
	    hilo = new HiloSimple(25, 100, contador, tableModel, rowIndex);
	    hilo.start();
	    
	    fireBotonPresionadoEvent();
	}
	
	public void addBotonPresionadoListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeBotonPresionadoListener(EventListener listener) {
        listeners.remove(listener);
    }
    
    private void fireBotonPresionadoEvent() {
        for (EventListener listener : listeners) {
            listener.update();
        }
    }	

	public HiloSimple getHilo() {
		return hilo;
	}

	public void setHilo(HiloSimple hilo) {
		this.hilo = hilo;
	}

	public Contador getCont() {
		return contador;
	}

	public void setCont(Contador contador) {
		this.contador = contador;
	}

}
