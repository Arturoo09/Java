package edu.ucam.hilosprodcons.back;

import java.util.Random;

public class Producer extends Thread {

	private final SharedBuffer buffer;
	Random r = new Random();

	public Producer(SharedBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			int item = 9;
			buffer.produce(item);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
