package persona;

public class Cliente extends Persona{
	
	double gasto;

	public Cliente(int edad, String nombre, String apellidos, String DNI, double altura, double gasto) {
		super(edad, nombre, apellidos, DNI, altura);
		this.gasto = gasto;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}
	
}
