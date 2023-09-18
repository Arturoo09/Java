package edu.ucam.hilosprodcons.back;

import java.util.Random;

public class Consumer extends Thread {
	private final SharedBuffer buffer;
	Random r = new Random();
	
	
	public Consumer(SharedBuffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				buffer.consume();
				Thread.sleep(100);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
