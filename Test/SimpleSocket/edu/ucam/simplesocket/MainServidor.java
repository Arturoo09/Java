package edu.ucam.simplesocket;

import java.io.IOException;

import edu.ucam.simplesocket.servidor.Servidor;

public class MainServidor {

	public static void main(String[] args) throws IOException {
		Servidor server = new Servidor();
		
		System.out.println("Iniciando servidor\n");
		
		server.start();
	}

}
