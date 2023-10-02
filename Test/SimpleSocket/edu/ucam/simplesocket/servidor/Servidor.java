package edu.ucam.simplesocket.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.ucam.simplesocket.conexion.Conexion;

public class Servidor extends Conexion{

	public Servidor() throws IOException {
		super("servidor");
	}
	
	public void start() {
		try {
			System.out.println("Esperando conexion...");
			
			cs = ss.accept();
			
			System.out.println("Cliente en línea.");
			
			salidaCliente.writeUTF("Petición recibida y aceptada.");
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			
			while((mensajeServidor = entrada.readLine()) != null) {
				System.out.println(mensajeServidor);
			}
			
			System.out.println("Fin de la conexion!");
			
			ss.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
