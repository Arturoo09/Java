package edu.ucam.chat.back.hilos;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ListenerThread extends Thread {
	
	private Scanner scanner;
	private Socket socket;
	
	public ListenerThread(Socket socket) throws IOException {
		this.socket = socket;
		this.scanner = new Scanner(socket.getInputStream());
	}
	
	@Override
	public void run() {
		try {
			while(scanner.hasNextLine()) {
				String message = scanner.nextLine();
				System.out.println(message);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
