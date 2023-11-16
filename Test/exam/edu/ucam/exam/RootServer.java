package edu.ucam.exam;

import java.io.IOException;

public class RootServer {

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.start();
	}
}
