package edu.ucam.hilos.back;

public class Contador {
	
	private int cont = 0;
	
	public synchronized void sumaUno() {
		this.cont++;
	}

	public int getContador() {
		return cont;
	}
}
