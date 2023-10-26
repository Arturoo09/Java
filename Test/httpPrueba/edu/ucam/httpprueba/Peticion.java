package edu.ucam.httpprueba;

import java.io.BufferedReader;
import java.io.IOException;

public class Peticion {

	private BufferedReader buffer;
	
	public Peticion(BufferedReader buffer) {
		this.buffer = buffer;
	}

	public void start() throws IOException {
		try {
			String linea = "";
			while((linea = buffer.readLine()) != null) {
				System.out.println(linea);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
