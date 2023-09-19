package edu.ucam.hilossinarray.back;

public class Hilo2 extends Thread {
	private String threadWord;

	public Hilo2(String threadWord) {
		this.threadWord = threadWord;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5; i++) {

				if (Thread.interrupted()) {
					return;
				}

				System.out.println("Hilo2: " + threadWord);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Hilo2 interrumpido.");
		}
	}
}
