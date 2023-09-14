package edu.ucam.repasopoo;

public class HolaMundo {

	private String name = "";
	
	public HolaMundo() {}
	
	public HolaMundo(String name) {
		this.name = name;
	}
	
	public void saludar() {
		System.out.println("Hola " + (!this.name.equals("")?" " +this.name:"")+ "!!");
	}
	
	public void pruebaNullPointer(String parametro) {
		if ("".equals(parametro)) {
			System.err.println("Está vacia");
		} else {
			System.err.println(parametro);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
