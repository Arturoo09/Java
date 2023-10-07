package edu.ucam.simplesocket.servidor;

import java.io.IOException;
import java.net.Socket;

import edu.ucam.simplesocket.conexion.Conexion;

public class Servidor extends Conexion{

	public Servidor() throws IOException {
		super("servidor");
	}
	
	public void start() {
		try {
			System.out.println("Esperando conexion...");
			
			Socket sock = ss.accept();
			inicializarFlujosServidor(sock);
			
			System.out.println("Cliente en línea.");
			
			String mensajeCliente;
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
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
