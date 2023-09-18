package edu.ucam.hilosprodcons.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import edu.ucam.hilosprodcons.back.Consumer;
import edu.ucam.hilosprodcons.back.Producer;
import edu.ucam.hilosprodcons.back.SharedBuffer;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	int bufferSize = 5;
	private SharedBuffer buffer = new SharedBuffer(bufferSize);
	private Consumer consumer;
	private Producer producer;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTittle = new JLabel("Threads Producer Consumer");
		lblTittle.setBounds(68, 11, 250, 19);
		lblTittle.setFont(new Font("Hack Nerd Font", Font.PLAIN, 16));
		contentPane.add(lblTittle);
		
		JButton btnProducer = new JButton("Producer");
		btnProducer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producer = new Producer(buffer);
				producer.start();
			}
		});
		btnProducer.setBounds(31, 41, 127, 43);
		contentPane.add(btnProducer);
		
		JButton btnConsumer = new JButton("Consumer");
		btnConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consumer = new Consumer(buffer);
				consumer.start();
			}
		});
		btnConsumer.setBounds(213, 41, 127, 43);
		contentPane.add(btnConsumer);
		
		JButton btnExecute = new JButton("Execute");
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numProducers = 3;
		        int numConsumers = 2;

		        for (int i = 0; i < numProducers; i++) {
		            new Producer(buffer).start();
		        }

		        for (int i = 0; i < numConsumers; i++) {
		            new Consumer(buffer).start();
		        }
			}
		});
		btnExecute.setBounds(31, 95, 127, 43);
		contentPane.add(btnExecute);
		
		JButton btnCancelConsumer = new JButton("Cancel Consumer");
        btnCancelConsumer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (consumer != null && consumer.isAlive()) {
                    consumer.interrupt();
                }
            }
        });
        btnCancelConsumer.setBounds(213, 95, 127, 43);
        contentPane.add(btnCancelConsumer);
	}
}
