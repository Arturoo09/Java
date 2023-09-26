package edu.ucam.hilos.back;

public class HiloSimple extends Thread {
	
	public static final int FOR_EVER = -1;
	protected long delay;
	protected int times;
	private int id = 0;
	private Contador contador;
	
	public HiloSimple(long delay, int times, Contador contador) {
		this.delay = delay;
		this.times = times;
		this.contador = contador;
		this.id++;
	}
	
	@Override
	public void run() {
		try {
			for (int aux = this.times; (this.times >= 0) || (aux == HiloSimple.FOR_EVER); this.times--) {
				System.out.println("Mi delay es de: " + this.delay);
				this.contador.sumaUno();
				sleep(this.delay);
			}
			
			System.out.println("Contador:  " + this.contador.getContador());
		} catch (Exception e) {
			System.out.println("Error...");
			System.err.println();
			System.err.println(e);
		}
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
