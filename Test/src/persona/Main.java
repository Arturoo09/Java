package persona;

public class Main {

	public static void main(String[] args) {

		Persona persona1 = new Persona(19, "Arturo", "Largo García", "54957299h", 1.75);
		
		System.out.println(persona1.getNombre());
		
		Persona cliente1 = new Cliente(25, "Carlos", "Pérez Ruiz", "12345678A", 1.80, 150.75);
		
		System.out.println(cliente1.getNombre());
	}
}
