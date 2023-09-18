package edu.ucam.hilosprodcons.back;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
	
	private final int capacity;
	private final Queue<Integer> buffer;
	
	public SharedBuffer(int capacity) {
		this.capacity = capacity;
		this.buffer = new LinkedList<>();
	}
	
	public synchronized void produce(int item) throws InterruptedException {
		while (buffer.size() == capacity) {
			wait();
		}
		
		buffer.offer(item);
		System.out.println("Produce: " + item);
		notifyAll();
	}
	
	public synchronized int consume() throws InterruptedException {
		while (buffer.isEmpty()) {
			wait();
		}
		
		int item = buffer.poll();
		System.out.println("Consume: " + item);
		notifyAll();
		return item;
	}
}
