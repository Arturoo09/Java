package edu.ucam.simplesocketprof;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static int PUERTO = 5000;
	
	public void ejecutar() {
		try {
			ServerSocket serverSocket = new ServerSocket(Servidor.PUERTO);
			
			
			System.out.print("Esperando conexión... ");
			Socket socket = serverSocket.accept();
			System.out.println("[ok]");
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String cadenaRecibida = br.readLine();
			
			System.out.println(cadenaRecibida);
			
			pw.println("Cadena recibida: " + cadenaRecibida);
			pw.flush();
			
			System.out.println("Fin del servidor");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void ejecutarInfinito() {
		try {
			ServerSocket serverSocket = new ServerSocket(Servidor.PUERTO);
			
			Socket socket = serverSocket.accept();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				pw.println(br.readLine());
				pw.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.ejecutarInfinito();

	}

}
