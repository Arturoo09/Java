package edu.ucam.simplesocket.servidor;

import java.io.IOException;
import java.net.Socket;

import edu.ucam.simplesocket.conexion.Conexion;

import edu.ucam.simplesocket.hilos.Hilo;

public class Servidor extends Conexion{
	
	private Hilo hilo;
	
	public Servidor() throws IOException {
		super("servidor");
	}
	
	public void start() {
		try {
			while (true) {
				System.out.println("Esperando conexion...");
				
				Socket sock = ss.accept();
				
				bufferServidor = inicializarBufferLectura(sock);
	        	salidaServidor = inicializarBufferEscritura(sock);
				
				System.out.println("Cliente en línea.");
				
			    hilo = new Hilo(bufferServidor, salidaServidor);
			    hilo.start();
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
