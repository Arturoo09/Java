package edu.ucam.exam2;

public class User {
	
	private String name;
	private int edad;
	
	public User(String name, int edad) {
		this.name = name;
		this.edad = edad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", edad=" + edad + "]";
	}

}
