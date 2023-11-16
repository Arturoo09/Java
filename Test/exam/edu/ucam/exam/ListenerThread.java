package edu.ucam.exam;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ListenerThread extends Thread {
	
	private Socket clientSocket;
	private Scanner scanner;
	
	public ListenerThread(Socket clientSocket) throws IOException{
		this.clientSocket = clientSocket;
		this.scanner = new Scanner(clientSocket.getInputStream());
	}

	@Override
	public void run() {
		try {
			while(scanner.hasNextLine()) {
				String message = scanner.nextLine();
				System.out.println(message);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
