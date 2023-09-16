package edu.ucam.hilos.back;

public class MiHilo extends Thread{
	
	private int threadNumber;
	
	public MiHilo(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo " + threadNumber + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
