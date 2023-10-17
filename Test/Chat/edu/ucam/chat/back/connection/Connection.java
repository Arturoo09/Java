package edu.ucam.chat.back.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Connection {
	
	private static final int PORT = 5000;
	private static final String HOST  = "127.0.0.1";
	protected ConcurrentMap<Socket, PrintWriter> clientMap = new ConcurrentHashMap<>();
	protected ConcurrentMap<Socket, String> clientNames = new ConcurrentHashMap<>();
	protected String mensajeServidor;
	protected ServerSocket ss;
	protected Socket cs;
	protected PrintWriter clientOut = null;
    protected BufferedReader bufferClient = null;	
    protected PrintWriter serverOut = null;
	protected BufferedReader bufferServer = null;
	
	public Connection(String tipo) throws IOException{
		if (tipo.equalsIgnoreCase("servidor")) {
			ss = new ServerSocket(PORT);
		}
		else {
			cs = new Socket(HOST, PORT);
		}
	}
	
	public BufferedReader inicializarBufferLectura(Socket cs) throws IOException {
        return new BufferedReader(new InputStreamReader(cs.getInputStream()));
    }

    public PrintWriter inicializarBufferEscritura(Socket cs) throws IOException {
        return new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
    }

	public static int getPort() {
		return PORT;
	}
}
