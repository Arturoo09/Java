package edu.ucam.hilos.back;

public class MiHilo2 extends Thread {
	private String threadWord;

	public MiHilo2(String threadWord) {
		this.threadWord = threadWord;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 50; i++) {

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
	@Override
    public String toString() {
        return "MiHilo2 {Nombre: " + getName() + ", ID: " + getId() + "}";
    }
}
