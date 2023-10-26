package edu.ucam.imap_test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Root {
	
	private static final int PORT = 993;
	private static final String HOST = "imap.gmail.com";
	
	public static void main(String[] args) {
		SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket sc = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT)) {
			System.out.println("[OK]");
			
			String username = "alargo@alu.ucam.edu";
			String password = "fezy kchy wvqb ubwe";
			
			InputStream inputStream = sc.getInputStream();
			OutputStream outputStream = sc.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			PrintWriter writer = new PrintWriter(outputStream, true);
			
			// Send login command
			writer.println("LOGIN " + username + " " + password);

			// Read the server's response
			String response = reader.readLine();
			System.out.println("Server Response: " + response);

			// Successfully logged in
			System.out.println(response);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
