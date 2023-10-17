package edu.ucam.chat.back.hilos;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import edu.ucam.chat.back.connection.Server;

public class ClientThread extends Thread{
	
	private Socket clientSocket;
	private Server serverInstance;
	private Scanner scanner;
	
	public ClientThread(Socket clientSocket, Server serverInstance) throws IOException {
		this.clientSocket = clientSocket;
		this.serverInstance = serverInstance;
		this.scanner = new Scanner(clientSocket.getInputStream());
	}

	@Override
	public void run() {
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			out.println("Por favor, introduzca su nombre: ");
			String clientName = scanner.nextLine();
			serverInstance.setClientName(clientSocket, clientName);
			
			out.println("¡Bienvenido al chat, " + clientName + "!");
			
			String message;
            while (scanner.hasNextLine()) {
                message = scanner.nextLine();
                if ("salir".equalsIgnoreCase(message.trim())) {
                    System.out.println("Cliente " + clientName + " ha salido.");
                    break;
                }
                
                System.out.println("\nCliente de nombre:" + clientName + "\nCon Address: " + clientSocket.getRemoteSocketAddress());
                System.out.println("A enviado: " + message + "\n\n");
                
                serverInstance.broadcast(message, clientSocket);
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			serverInstance.removeClient(clientSocket);
			try {
				clientSocket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
