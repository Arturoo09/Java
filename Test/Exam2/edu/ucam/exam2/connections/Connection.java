package edu.ucam.exam2.connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
	
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 5000;
	protected ServerSocket ss;
	protected Socket sc;
	protected BufferedReader serverBuffer = null;
	protected PrintWriter serverOut = null;
	protected BufferedReader clientBuffer = null;
	protected PrintWriter clientOut = null;
	
	public Connection(String tipo) throws IOException{
		if("servidor".equalsIgnoreCase(tipo)) {
			ss = new ServerSocket(PORT);
		}else {
			sc = new Socket(HOST, PORT);
		}
	}
	
	public BufferedReader inicializarBufferReader(Socket sc) throws IOException{
		return new BufferedReader(new InputStreamReader(sc.getInputStream()));
	}
	
	public PrintWriter inicializarPrintWriter(Socket sc) throws IOException{
		return new PrintWriter(new OutputStreamWriter(sc.getOutputStream()));
	}
	
	public int getPort() {
		return PORT;
	}
}
