package persona;

public class Persona {
	
	int edad;
	String nombre;
	String apellidos;
	String DNI;
	double altura;
	
	public Persona(int edad, String nombre, String apellidos, String DNI, double altura) {
		this.edad = edad;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		this.altura = altura;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
}
