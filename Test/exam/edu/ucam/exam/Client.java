package edu.ucam.exam;

import java.io.IOException;
import java.util.Scanner;

public class Client extends Connection{
	
	private Scanner scanner;
	
	public Client() throws IOException {
		super("cliente");
		scanner = new Scanner(System.in);
	}
	
	public void start() throws IOException {
		try {
			ListenerThread listenerThread = new ListenerThread(sc);
			listenerThread.start();
			
			clientOut = inicializarPrintWriter(sc);
			
			String input;
			while ((input = scanner.nextLine()) != null) {
				clientOut.println(input);
				clientOut.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
