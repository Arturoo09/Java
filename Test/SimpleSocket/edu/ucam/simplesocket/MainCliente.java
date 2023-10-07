package edu.ucam.simplesocket;

import java.io.IOException;

import edu.ucam.simplesocket.cliente.Cliente;

public class MainCliente {

	public static void main(String[] args) throws IOException {
		Cliente client = new Cliente();
		
		System.out.println("Iniciando cliente\n");
		
		client.start();
	}
}
