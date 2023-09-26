package edu.ucam.hilos.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.ucam.hilos.back.Contador;
import edu.ucam.hilos.back.HiloSimple;

import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana extends JFrame {
	
	private static final String FONT = "Hack Nerd Font";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BotonLanzarHilo botonLanzarHilo;
	private HiloSimple hilo;
	private Contador contador;
	private JTable hiloTable;
    private DefaultTableModel tableModel;

	public Ventana() {
		
		contador = new Contador();
		hilo = new HiloSimple(10, 50, contador);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLanzar = new JButton("LANZAR");
		btnLanzar.setBackground(SystemColor.menu);
		btnLanzar.setFont(new Font(FONT, Font.PLAIN, 14));
		btnLanzar.setBounds(10, 15, 189, 41);
		contentPane.add(btnLanzar);
		
		JLabel lblTitulo = new JLabel("CONTADOR:");
		lblTitulo.setFont(new Font(FONT, Font.PLAIN, 25));
		lblTitulo.setBounds(221, 15, 135, 41);
		contentPane.add(lblTitulo);
		
		JLabel lblContador = new JLabel("0");
		lblContador.setFont(new Font(FONT, Font.PLAIN, 25));
		lblContador.setBounds(366, 15, 25, 41);
		contentPane.add(lblContador);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Nombre del Hilo");
		tableModel.addColumn("Contador");
		
		hiloTable = new JTable(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(hiloTable);
		scrollPane.setBounds(10, 67, 392, 331);
		contentPane.add(scrollPane);
		
		botonLanzarHilo = new BotonLanzarHilo(hilo, contador, tableModel);
		
		btnLanzar.addActionListener(botonLanzarHilo);
	}
}
