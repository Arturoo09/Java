package edu.ucam.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Connection {

	private List<Socket> clientList = new ArrayList<>();

	public Server() throws IOException {
		super("Servidor");
	}

	public void addClient(Socket sc) {
		this.clientList.add(sc);
	}

	public void showClientList(PrintWriter printWriter) {
		for (Socket socket : clientList) {
			printWriter.println(socket);
			printWriter.flush();
		}
	}

	public void start() throws IOException {

		System.out.println("SERVIDOR INICIADO EN EL PUERTO : " + getPort());
		System.out.println("========================================================\n");

		while (true) {
			Socket clientSocket = ss.accept();
			System.out.println("Cliente Aceptado en el servidor : " + clientSocket.getRemoteSocketAddress());

			this.addClient(clientSocket);
			serverOut = inicializarPrintWriter(clientSocket);

			ServerThread serverThread = new ServerThread(clientSocket, serverOut, this);
			serverThread.start();

		}
	}
}
