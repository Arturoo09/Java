package edu.ucam.chat.back.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import edu.ucam.chat.back.hilos.ClientThread;

public class Server extends Connection{
	
	private ClientThread threadClient;
	
	public Server() throws IOException{
		super("Servidor");
	}
	
	public void broadcast(String message, Socket sender, int flag) {
		String clientName = this.getClientName(sender);
		String formattedMessage = clientName + ": " + message;
		String formattedMessageExit = clientName + message;
		
		for(Map.Entry<Socket, PrintWriter> entry : clientMap.entrySet()) {
			Socket socket = entry.getKey();
			PrintWriter outPrintWriter = entry.getValue();
			
			if (socket != sender) {
				if (flag != 0) {
					outPrintWriter.println(formattedMessageExit);
				    outPrintWriter.flush();
				    continue;
				}
			    outPrintWriter.println(formattedMessage);
			    outPrintWriter.flush();
			}
		}
	}
	
	public void addClient(Socket clientSocket, PrintWriter out) {
		this.clientMap.put(clientSocket, out);
	}
	
	public void removeClient(Socket clientSocket) {
		PrintWriter out = this.clientMap.remove(clientSocket);
		
		if (out != null) {
			out.close();
		}
	}
	
	public String getClientName(Socket clientSocket) {
		return this.clientNames.get(clientSocket);
	}
	
	public void setClientName(Socket clientSocket, String name) {
		this.clientNames.put(clientSocket, name);
	}

	public void start() {
		try {
			System.out.println("======================================");
			System.out.println("|    Server iniciado en el " + Connection.getPort() + "	     |");
			System.out.println("======================================");
			System.out.println("\nEsperando conexion...");
			
			while(true) {
				Socket clientSocket = ss.accept();
				System.out.println("Nuevo cliente conectado: " + clientSocket.getRemoteSocketAddress());
				
				PrintWriter clientOut = inicializarBufferEscritura(clientSocket);
				addClient(clientSocket, clientOut);
				
				threadClient = new ClientThread(clientSocket, this);
				threadClient.start();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
