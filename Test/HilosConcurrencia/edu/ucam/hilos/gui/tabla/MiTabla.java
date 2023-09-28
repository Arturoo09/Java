package edu.ucam.hilos.gui.tabla;

import javax.swing.table.DefaultTableModel;

import edu.ucam.hilos.gui.EventListener;

public class MiTabla extends DefaultTableModel {
    
	private static final long serialVersionUID = 1L;
	private EventListener listener;
	
	private static final String[] COLUMN_NAMES = { "Nombre del Hilo", "Contador" };

    public MiTabla() {
        super(COLUMN_NAMES, 0);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    public void addHilo(String nombre, int contador) {
        this.addRow(new Object[]{ nombre, contador });
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
   
}