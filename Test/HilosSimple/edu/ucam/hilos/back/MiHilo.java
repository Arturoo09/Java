package edu.ucam.hilos.back;

public class MiHilo extends Thread {

	public MiHilo() {}
	
	@Override
	public void run() {
		try {
			for (int i = 1; i <= 50; i++) {

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
