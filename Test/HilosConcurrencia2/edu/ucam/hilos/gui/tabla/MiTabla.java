package edu.ucam.hilos.gui.tabla;

import javax.swing.table.DefaultTableModel;

import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.back.HiloSimple;
import edu.ucam.hilos.gui.EventListener;

public class MiTabla extends DefaultTableModel implements ListaHilosObserver{
    
	private static final long serialVersionUID = 1L;
	private EventListener listener;
	private GestorHilos gestorHilos;
	
	private static final String[] COLUMN_NAMES = { "Nombre del Hilo", "Contador"};

    public MiTabla(GestorHilos gestorHilos) {
        super(COLUMN_NAMES, 0);
        this.gestorHilos = gestorHilos;
    }
    
    @Override
	public void hiloEliminado(HiloSimple hilo) {
		for (int i = 0; i < getRowCount(); i++) {
	        if (getValueAt(i, 0).equals(hilo.toString())) {
	            removeRow(i);
	            break;
	        }
	    }
		
		for (int i = 0; i < getRowCount(); i++) {
	        HiloSimple hiloActual = gestorHilos.getHiloAt(i);
	        hiloActual.setRowIndex(i);
	    }

	}

	@Override
	public void todosHilosEliminados() {
	    while (getRowCount() > 0) {
	        removeRow(0);
	    }
	}
    
    @Override
	public void hiloRegistrado(HiloSimple hilo,  int contador) {
    	this.addRow(new Object[]{ hilo.toString(), contador});
	}
    
    @Override
    public void setValueAt(Object aValue, int row, int column) {
    	super.setValueAt(aValue, row, column);
    	
    	if (column == 1 && listener !=null) {
    		listener.updateContadorTotal();
    	}
    }
    
    public void setEventListener(EventListener listener) {
        this.listener = listener;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}