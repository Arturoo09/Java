package edu.ucam.hilossync.back;

public class BankAccount {
	
	private int balance = 1000;
	
	public synchronized void deposit(int amount) {
		balance += amount;
	}
	
	public synchronized void withdraw(int amount) {
		if (balance >= amount)
			balance -= amount;
		else
			System.err.println("Insufficient balance.");
	}
	
	public synchronized int getBalance() {
		return balance;
	}
}
