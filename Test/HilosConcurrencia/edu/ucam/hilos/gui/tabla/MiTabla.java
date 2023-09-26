package edu.ucam.hilos.gui.tabla;

import javax.swing.table.DefaultTableModel;

public class MiTabla extends DefaultTableModel {
    
	private static final long serialVersionUID = 1L;
	
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

}