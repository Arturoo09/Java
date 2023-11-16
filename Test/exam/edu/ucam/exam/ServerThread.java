package edu.ucam.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
	
	private Socket clientSocket;
	private PrintWriter clientOut;
	private Scanner scanner;
	private Server serverInstance;
	
	public ServerThread(Socket clientSocket, PrintWriter clientOut, Server serverInstance) throws IOException{
		this.clientSocket = clientSocket;
		this.clientOut = clientOut;
		this.serverInstance = serverInstance;
		this.scanner = new Scanner(clientSocket.getInputStream());
	}

	@Override
	public void run() {
		try {
			String message;
			while(scanner.hasNextLine()) {
				message = scanner.nextLine();
				
				String option = scanner.nextLine();
				switch (option) {
				case "-r": {
					clientOut.println("HOLA PUTITAAA");
					clientOut.flush();
					break;
				}
				case "-g":{
					
					break;
				}
				case "-h":{
					this.serverInstance.showClientList(clientOut);
					break;
				}
				default:
					clientOut.println("> " + message);
					clientOut.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
				scanner.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
