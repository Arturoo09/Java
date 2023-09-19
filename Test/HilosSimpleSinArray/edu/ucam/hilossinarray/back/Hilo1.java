package edu.ucam.hilossinarray.back;

public class Hilo1 extends Thread {

	public Hilo1() {}
	
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {

				if (Thread.interrupted()) {
					return;
				}

				System.out.println("Hilo1: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Hilo1 interrumpido.");
		}
	}
}
