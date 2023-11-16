package edu.ucam.exam2.threads;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;

import edu.ucam.exam2.User;
import edu.ucam.exam2.connections.Server;

public class ServerThread extends Thread {

	private PrintWriter serverOut;
	private BufferedReader serverBuffer;
	private Server server;
	
	
	public ServerThread(PrintWriter serverOut, 
			BufferedReader serverBuffer, Server server){
		this.serverOut = serverOut;
		this.serverBuffer = serverBuffer;
		this.server = server;
	}


	@Override
	public void run(){
		
		try {
			String [] input;
			
			while(true) {
				
				input = serverBuffer.readLine().split(" ");
				System.out.println(Arrays.toString(input));
				
				if ("exit".equalsIgnoreCase(input[0])) {
					break;
				}
				switch (input[0]) {
				case "ADD":
					if (input.length == 4) {
						User newUser = new User(input[2], Integer.parseInt(input[3]));
						server.addUser(input[1], newUser);
						
						serverOut.println("Se ha añadido el usuario al sistema!!!");
						serverOut.flush();
					}
					else {
						serverOut.println("ERROR!!");
						serverOut.flush();
					}
					
					break;
				
				case "GET":
					if (input.length == 2) {
						
						server.getUser(input[1], serverOut);
						
					}else {
						serverOut.println("ERROR!!");
						serverOut.flush();
					}
					
					break;
				
				case "REMOVE": 
					if (input.length == 3) {
						
						server.removeUser(input[1], input[2], serverOut);
						
					}else {
						serverOut.println("ERROR!!");
						serverOut.flush();
					}
					break;
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + input[0]);
				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
