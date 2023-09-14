package edu.ucam.repasopoo.herencia;

public abstract class Poligono {
	
	private int lados;

	public abstract int getLados();
	
	public Poligono() {}
	
	public Poligono(int lados) {
		this.lados = lados;
	}
	
	public void setLados(int lados) {
		this.lados = lados;
	}
}
