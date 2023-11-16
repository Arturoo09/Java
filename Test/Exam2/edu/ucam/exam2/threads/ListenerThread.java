package edu.ucam.exam2.threads;

import java.io.BufferedReader;

public class ListenerThread extends Thread{
	
	private BufferedReader clientBuffer;
	
	public ListenerThread(BufferedReader clientBuffer) {
		this.clientBuffer = clientBuffer;
	}



	@Override
	public void run() {
		try {
			
			String serverMessage;
			
			while((serverMessage = clientBuffer.readLine()) != null) {
				System.out.println(serverMessage);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
