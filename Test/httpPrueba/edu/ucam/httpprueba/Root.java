package edu.ucam.httpprueba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Root {
	
	private static final int PORT = 80;
	private static final String HOST = "www.ucam.edu";
	
	public static void main(String[] args) throws IOException {
		try (Socket sc = new Socket(HOST,PORT)) {
			System.out.println("[OK]");

			BufferedReader buffer = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(sc.getOutputStream()), true);
			
			out.println("GET / HTTP/1.1");
			out.println("Host: " + HOST);
            out.println("Connection: Close");
            out.println();
		
            Peticion thread = new Peticion(buffer);
            thread.start();
			
			buffer.close();
            out.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
