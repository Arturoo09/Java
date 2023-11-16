package edu.ucam.exam;

import java.io.IOException;

public class RootClient {

	public static void main(String[] args) throws IOException {
		Client client = new Client();
		client.start();
	}
}
