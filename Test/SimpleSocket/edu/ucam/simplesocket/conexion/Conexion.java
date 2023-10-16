package edu.ucam.simplesocket.conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	
	private static final int PUERTO = 5000;
	private static final String HOST  = "127.0.0.1";
	protected String mensajeServidor;
	protected ServerSocket ss;
	protected Socket cs;
	protected PrintWriter salidaCliente = null;
    protected BufferedReader bufferCliente = null;	
    protected PrintWriter salidaServidor = null;
	protected BufferedReader bufferServidor = null;
	
	public Conexion(String tipo) throws IOException{
		if (tipo.equalsIgnoreCase("servidor")) {
			ss = new ServerSocket(PUERTO);
		}
		else {
			cs = new Socket(HOST, PUERTO);
		}
	}
	
	public BufferedReader inicializarBufferLectura(Socket cs) throws IOException {
        return new BufferedReader(new InputStreamReader(cs.getInputStream()));
    }

    public PrintWriter inicializarBufferEscritura(Socket cs) throws IOException {
        return new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
    }
}
