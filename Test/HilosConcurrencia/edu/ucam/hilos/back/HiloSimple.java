package edu.ucam.hilos.back;

import javax.swing.table.DefaultTableModel;

public class HiloSimple extends Thread {
	
	public static final int FOR_EVER = -1;
	protected long delay;
	protected int times;
	private Contador contador;
	private static int currentId = 0;
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
	            System.out.println("Mi delay es de: " + this.delay);
	            this.contador.sumaUno();
	            
	            javax.swing.SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                	defaultTableModel.setValueAt(contador.getContador(), rowIndex, 1); 
	                }
	            });

	            sleep(this.delay);
	        }
			
			System.out.println("Contador:  " + this.contador.getContador());
		} catch (Exception e) {
			System.out.println("Error...");
			System.err.println();
			System.err.println(e);
		}
	}

	@Override
	public String toString() {
		return "ID=" + id + ", Contador=" + contador;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contador getContador() {
		return contador;
	}

	public void setContador(Contador contador) {
		this.contador = contador;
	}

	public static int getForEver() {
		return FOR_EVER;
	}
	
}
