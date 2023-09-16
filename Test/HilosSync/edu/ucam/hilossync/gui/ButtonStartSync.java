package edu.ucam.hilossync.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ucam.hilossync.back.BankAccount;

public class ButtonStartSync implements ActionListener {

	private final BankAccount account = new BankAccount();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Runnable depositTask = () -> {
			for (int i = 0; i < 5; i++) {
				try {
					account.deposit(100);
					System.err.println("Deposited $100. New balance: " + account.getBalance());
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		
		Runnable withdrawTask = () -> {
			for (int i = 0; i < 5; i++) {
				try {
					account.withdraw(100);
					System.err.println("Withdrawn $100. New balance: " + account.getBalance());
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		};
		
		Thread thread1 = new Thread(depositTask);
		Thread thread2 = new Thread(withdrawTask);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}

}
