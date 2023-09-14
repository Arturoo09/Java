package edu.ucam.repasopoo.herencia;

public class Cuadrado extends Poligono{
	
	public Cuadrado() {
		this.setLados(4);
	}
	
	public Cuadrado(int lados) {
		super(lados);
	}

	@Override
	public int getLados() {
		return 4;
	}
}
