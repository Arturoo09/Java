package edu.ucam.exam2;

import java.io.IOException;

import edu.ucam.exam2.connections.Client;

public class RootClient {

	public static void main(String[] args) throws IOException {
		Client client = new Client();
		client.start();

	}

}
