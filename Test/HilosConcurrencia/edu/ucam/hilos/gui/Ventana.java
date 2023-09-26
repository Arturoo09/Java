package edu.ucam.hilos.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ucam.hilos.gui.botones.BotonLanzarHilo;
import edu.ucam.hilos.gui.botones.BotonLanzarHiloDefault;
import edu.ucam.hilos.gui.tabla.MiTabla;

import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.PrintStream;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame implements EventListener{
	
	private static final String FONT = "Hack Nerd Font";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BotonLanzarHilo botonLanzarHilo;
	private BotonLanzarHiloDefault botonLanzarHiloDefault;
	private JTable hiloTable;
    private MiTabla tableModel;
    private JTextArea textArea;
    private int contadorBotonPresionado = 0;
    private JLabel lblContador;
    private JTextField txtDelay;
    private JTextField txtTimes;
    
	public Ventana() {
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLanzar = new JButton("LANZAR");
		btnLanzar.setBackground(SystemColor.control);
		btnLanzar.setFont(new Font(FONT, Font.PLAIN, 14));
		btnLanzar.setBounds(622, 153, 138, 41);
		contentPane.add(btnLanzar);
		
		JButton btnLanzarDefault = new JButton("LANZAR DEFAULT");
		btnLanzarDefault.setFont(new Font(FONT, Font.PLAIN, 14));
		btnLanzarDefault.setBackground(SystemColor.control);
		btnLanzarDefault.setBounds(439, 153, 148, 41);
		contentPane.add(btnLanzarDefault);
		
		lblContador = new JLabel("Contador: 0");
		lblContador.setFont(new Font(FONT, Font.PLAIN, 25));
		lblContador.setBounds(510, 45, 182, 41);
		contentPane.add(lblContador);
		
		tableModel = new MiTabla();
		hiloTable = new JTable(tableModel);
		
		JScrollPane scrollPaneTabla = new JScrollPane(hiloTable);
		scrollPaneTabla.setBounds(10, 44, 392, 424);
		contentPane.add(scrollPaneTabla);
		
		JLabel lblTabla = new JLabel("Tabla");
		lblTabla.setFont(new Font(FONT, Font.PLAIN, 25));
		lblTabla.setBounds(164, 11, 87, 22);
		contentPane.add(lblTabla);
		
		JScrollPane scrollPaneConsola = new JScrollPane();
		scrollPaneConsola.setBounds(412, 250, 366, 218);
		contentPane.add(scrollPaneConsola);
		
		textArea = new JTextArea();
		scrollPaneConsola.setViewportView(textArea);
		
		OutputConsola outputConsola = new OutputConsola(textArea);
		
		JLabel lblConsola = new JLabel("Consola");
		lblConsola.setFont(new Font(FONT, Font.PLAIN, 25));
		lblConsola.setBounds(537, 217, 114, 22);
		contentPane.add(lblConsola);
		
		JLabel lblDelay = new JLabel("Delay");
		lblDelay.setFont(new Font(FONT, Font.PLAIN, 16));
		lblDelay.setBounds(429, 112, 59, 22);
		contentPane.add(lblDelay);
		
		JLabel lblTimes = new JLabel("Times");
		lblTimes.setFont(new Font(FONT, Font.PLAIN, 16));
		lblTimes.setBounds(612, 112, 59, 22);
		contentPane.add(lblTimes);
		
		txtDelay = new JTextField();
		txtDelay.setBounds(498, 115, 86, 20);
		contentPane.add(txtDelay);
		txtDelay.setColumns(10);
		
		txtTimes = new JTextField();
		txtTimes.setColumns(10);
		txtTimes.setBounds(674, 115, 86, 20);
		contentPane.add(txtTimes);
		
		PrintStream printStream = new PrintStream(outputConsola);
        System.setOut(printStream);
		
        botonLanzarHiloDefault = new BotonLanzarHiloDefault(tableModel);
		botonLanzarHilo = new BotonLanzarHilo(tableModel, txtDelay, txtTimes);
		
		btnLanzar.addActionListener(botonLanzarHilo);
		btnLanzarDefault.addActionListener(botonLanzarHiloDefault);
		
		botonLanzarHilo.addBotonPresionadoListener(this);
		botonLanzarHiloDefault.addBotonPresionadoListener(this);
	}

	@Override
	public void update() {
		contadorBotonPresionado++;
		lblContador.setText("Contador: " + contadorBotonPresionado);
	}
}
