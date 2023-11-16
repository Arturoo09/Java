package edu.ucam.chat.back.connection;

import java.io.IOException;
import java.util.Scanner;
import edu.ucam.chat.back.hilos.ListenerThread;

public class Client extends Connection{

	public Client() throws IOException{
		super("Cliente");
	}
	
	public void start() {
		System.out.println("Iniciando cliente...\n");
        try {
        	ListenerThread listener = new ListenerThread(cs);
        	listener.start();
        	
        	serverOut = inicializarBufferEscritura(cs);
            try (Scanner keyboardScanner = new Scanner(System.in)) {
				String input;
				while ((input = keyboardScanner.nextLine()) != null) {
				    if ("salir".equalsIgnoreCase(input.trim())) {
				        serverOut.println(input);
				        serverOut.flush();
				        cs.close();
				        break;
				    }
				    serverOut.println(input);
				    serverOut.flush();
				}
			}

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
