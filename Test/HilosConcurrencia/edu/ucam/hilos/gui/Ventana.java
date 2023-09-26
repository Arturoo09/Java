package edu.ucam.hilos.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana extends JFrame implements EventListener{
	
	private static final String FONT = "Hack Nerd Font";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BotonLanzarHilo botonLanzarHilo;
	private JTable hiloTable;
    private DefaultTableModel tableModel;
    private int contadorBotonPresionado = 0;
    private JLabel lblContador;
    
	public Ventana() {
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLanzar = new JButton("LANZAR");
		btnLanzar.setBackground(SystemColor.control);
		btnLanzar.setFont(new Font(FONT, Font.PLAIN, 14));
		btnLanzar.setBounds(10, 15, 189, 41);
		contentPane.add(btnLanzar);
		
		lblContador = new JLabel("CONTADOR: 0");
		lblContador.setFont(new Font(FONT, Font.PLAIN, 25));
		lblContador.setBounds(209, 15, 182, 41);
		contentPane.add(lblContador);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Nombre del Hilo");
		tableModel.addColumn("Contador");
		
		hiloTable = new JTable(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(hiloTable);
		scrollPane.setBounds(10, 67, 392, 331);
		contentPane.add(scrollPane);
		
		botonLanzarHilo = new BotonLanzarHilo(tableModel);
		botonLanzarHilo.addBotonPresionadoListener(this);
		
		btnLanzar.addActionListener(botonLanzarHilo);
	}

	@Override
	public void update() {
		contadorBotonPresionado++;
		lblContador.setText("CONTADOR: " + contadorBotonPresionado);
	}
}
