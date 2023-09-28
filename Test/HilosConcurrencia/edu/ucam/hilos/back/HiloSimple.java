package edu.ucam.hilos.back;

import javax.swing.table.DefaultTableModel;

public class HiloSimple extends Thread {
	
	public static final int FOR_EVER = -1;
	protected long delay;
	protected int times;
	private Contador contador;
	private static int currentId = 1;
	private int id;
	private DefaultTableModel defaultTableModel;
	private int rowIndex;

	public HiloSimple(long delay, int times, Contador contador, DefaultTableModel defaultTableModel, int rowIndex) {
	    this.delay = delay;
	    this.times = times;
	    this.contador = contador;
	    this.id = currentId++;
	    this.defaultTableModel = defaultTableModel;
	    this.rowIndex = rowIndex;
	}
	
	@Override
	public void run() {
		try {
			for (int aux = 0; aux < times || times == FOR_EVER; aux++) {
	            System.out.println("Ejecutando Hilo-" + this.id + ", con " + this.delay + "ms de Delay");
	            this.contador.sumaUno();
	            
	            javax.swing.SwingUtilities.invokeLater(() -> 
	                defaultTableModel.setValueAt(contador.getContador(), rowIndex, 1)
	            );

	            sleep(this.delay);
	        }
			
			System.out.println("Contador:  " + this.contador.getContador());
		} catch (Exception e) {
			System.out.println("Error...");
			System.err.println();
			System.err.println(e);
		}
	}
}
