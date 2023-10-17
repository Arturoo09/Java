package edu.ucam.chat;

import java.io.IOException;

import edu.ucam.chat.back.connection.Client;

public class RootClient {

	public static void main(String[] args) throws IOException {
		Client client = new Client();
		
		client.start();
	}
}
