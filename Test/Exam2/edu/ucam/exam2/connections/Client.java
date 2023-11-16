package edu.ucam.exam2.connections;

import java.io.IOException;
import java.util.Scanner;

import edu.ucam.exam2.threads.ListenerThread;

public class Client extends Connection{
	
	private Scanner scanner;
	
	public Client() throws IOException {
		super("cliente");	
		this.scanner = new Scanner(System.in); 
	}
	
	public void start() {
		
		System.out.println("INICIANDO CLIENTE EN EL SERVIDOR...");
		
		try {
			clientOut = inicializarPrintWriter(sc);
			clientBuffer = inicializarBufferReader(sc);
			
			ListenerThread listenerThread = new ListenerThread(clientBuffer);
			listenerThread.start();
			
			String input;
			while((input = scanner.nextLine()) != null) {
				clientOut.println(input);
				clientOut.flush();
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
