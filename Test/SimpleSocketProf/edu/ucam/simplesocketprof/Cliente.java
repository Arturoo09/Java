package edu.ucam.simplesocketprof;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public void ejecutar() {
		try {
			
			System.out.print("Lanzando conexión... ");
			Socket socket = new Socket("127.0.0.1", Servidor.PUERTO);
			System.out.println("[ok]");
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			pw.println("Hola servidor");
			pw.flush();
			
			
			String cadenaRecibida = br.readLine();
			
			System.out.println(cadenaRecibida);
			
			
			System.out.println("Fin del cliente");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void ejecutarInfinito() {
		try {
			
			System.out.print("Lanzando conexión... ");
			Socket socket = new Socket("127.0.0.1", Servidor.PUERTO);
			System.out.println("[ok]");
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			
			String lineaLeida = "";
			Scanner teclado = new Scanner(System.in);
			
			
			while(true) {
				lineaLeida = teclado.nextLine();
			
				pw.println(lineaLeida);
				pw.flush();
				
				System.out.println(">" + br.readLine());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.ejecutarInfinito();

	}

}
