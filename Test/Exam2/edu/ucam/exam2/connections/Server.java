package edu.ucam.exam2.connections;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Hashtable;

import edu.ucam.exam2.User;
import edu.ucam.exam2.threads.ServerThread;

public class Server extends Connection{
	
	private Hashtable<String, ArrayList<User>> users = new Hashtable<>();

	public Server() throws IOException {
		super("servidor");	
	}
	
	public void addUser(String key, User newUser) {
		
		if(!users.containsKey(key)) {
			ArrayList<User> listUsers = new ArrayList<>();
			listUsers.add(newUser);
			users.put(key, listUsers);
			
		}else{				users.get(key).add(newUser);
		}
	}
	
	public void getUser(String key, PrintWriter serverOut) {
		
		if(users.containsKey(key)) {
			for (User user: users.get(key)) {
				serverOut.println(user.toString());
				serverOut.flush();
			}
		}else{	
			serverOut.println("El usuario " + key + " no existe!!!");
			serverOut.flush();
		}
	}
	
	public void removeUser(String key, String username, PrintWriter serverOut) {
		
		if(users.containsKey(key)) {
			for (User user: users.get(key)) {
				if (user.getName().equals(username)) {
					users.get(key).remove(user);
				}
			}
			
			serverOut.println(username + " eliminado correctamente.");
			serverOut.flush();
		}else{	
			serverOut.println("El usuario " + key + " no existe!!!");
			serverOut.flush();
		}
	}
	
	public void start() throws IOException {
		System.out.println("INICIALIZANDO SERVIDOR EN EL PUERTO : " + getPort());
		System.out.println("=============================================");
		try {
			while(true) {
				Socket clientSocket = ss.accept();
				
				System.out.println("Cliente aceptado : " + clientSocket.getRemoteSocketAddress());
				
				serverOut = inicializarPrintWriter(clientSocket);
				serverBuffer = inicializarBufferReader(clientSocket);
				
				ServerThread serverThread = new ServerThread(serverOut, serverBuffer, this);
				serverThread.start();
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
