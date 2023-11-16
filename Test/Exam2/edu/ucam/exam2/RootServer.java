package edu.ucam.exam2;

import java.io.IOException;

import edu.ucam.exam2.connections.Server;

public class RootServer {

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start();

	}

}
