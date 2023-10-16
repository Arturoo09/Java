package edu.ucam.simplesocket.cliente;

import java.io.IOException;
import java.util.Scanner;

import edu.ucam.simplesocket.conexion.Conexion;

public class Cliente extends Conexion{
	
    public Cliente() throws IOException {
        super("cliente");
    }

    public void start() {
        try {
            
        	bufferCliente = inicializarBufferLectura(cs);
        	salidaCliente = inicializarBufferEscritura(cs);
            
            String lineaLeida = "";
			try (Scanner teclado = new Scanner(System.in)) {
				while (true) {
				    lineaLeida = teclado.nextLine();
				    salidaCliente.println(lineaLeida);
				    salidaCliente.flush();

				    String respuestaServidor = bufferCliente.readLine();
				    if (respuestaServidor != null) {
				        System.out.println("> " + respuestaServidor);
				        if (respuestaServidor.equalsIgnoreCase("Desconectado")) {
				            System.out.println("Desconectado por el servidor.");
				            break;
				        }
				    }
				}
			}
			
			cs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
