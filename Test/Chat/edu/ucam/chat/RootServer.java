package edu.ucam.chat;

import java.io.IOException;

import edu.ucam.chat.back.connection.Server;

public class RootServer {
	
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		
		server.start();
	}
}
