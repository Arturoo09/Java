package edu.ucam.simplesocket.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Hilo extends Thread {
	
	private BufferedReader bufferServidor;
    private PrintWriter salidaServidor;
	
	public Hilo(BufferedReader bufferServidor, PrintWriter salidaServidor) {
		this.bufferServidor = bufferServidor;
        this.salidaServidor = salidaServidor;
	}
	
	@Override
	public void run() {
		
		String mensajeCliente;
		
		try {
			while ((mensajeCliente = bufferServidor.readLine()) != null) {
			    if (mensajeCliente.equalsIgnoreCase("salir")) {
			        System.out.println("Cliente solicitó desconexión.");
			        salidaServidor.println("Desconectado");
			        salidaServidor.flush();
			        break; 
			    }
			    
			    System.out.println("Cliente: " + mensajeCliente);
			    salidaServidor.println(mensajeCliente);
			    salidaServidor.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
