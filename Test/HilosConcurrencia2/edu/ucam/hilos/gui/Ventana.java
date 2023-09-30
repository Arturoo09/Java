package edu.ucam.hilos.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.gui.botones.BotonLanzarHilo;
import edu.ucam.hilos.gui.botones.BotonLanzarHiloDefault;
import edu.ucam.hilos.gui.botones.BotonPararHilo;
import edu.ucam.hilos.gui.botones.BotonPararTodos;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame implements EventListener{
	
	private static final String FONT = "Hack Nerd Font";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private BotonLanzarHilo botonLanzarHilo;
	private BotonLanzarHiloDefault botonLanzarHiloDefault;
	private BotonPararHilo botonPararHilo;
	private BotonPararTodos botonPararTodos;
	private JTable hiloTable;
    private MiTabla tableModel;
    private JTextArea textArea;
    private JLabel lblContadorHilos;
    private JLabel lblContadorTotal;
    private JTextField txtDelay;
    private JTextField txtTimes;
    
    private GestorHilos gestorHilos;
    
	public Ventana() {
		setResizable(false);
		
		gestorHilos = new GestorHilos();
		gestorHilos.setEventListener(this);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 524);
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
		
		lblContadorHilos = new JLabel("Contador Hilos: 0");
		lblContadorHilos.setFont(new Font(FONT, Font.PLAIN, 25));
		lblContadorHilos.setBounds(429, 11, 366, 30);
		contentPane.add(lblContadorHilos);
		
		tableModel = new MiTabla(gestorHilos);
		gestorHilos.registerObserver(tableModel);
		
		hiloTable = new JTable(tableModel);
		
		JScrollPane scrollPaneTabla = new JScrollPane(hiloTable);
		scrollPaneTabla.setBounds(10, 44, 392, 379);
		contentPane.add(scrollPaneTabla);
		
		JLabel lblTabla = new JLabel("Tabla");
		lblTabla.setFont(new Font(FONT, Font.PLAIN, 25));
		lblTabla.setBounds(164, 11, 87, 22);
		contentPane.add(lblTabla);
		
		JScrollPane scrollPaneConsola = new JScrollPane();
		scrollPaneConsola.setBounds(412, 250, 366, 173);
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
		
        botonLanzarHiloDefault = new BotonLanzarHiloDefault(tableModel, gestorHilos);
		botonLanzarHilo = new BotonLanzarHilo(tableModel, gestorHilos, txtDelay, txtTimes);
		botonPararHilo = new BotonPararHilo(tableModel, gestorHilos, hiloTable);
		botonPararTodos = new BotonPararTodos(tableModel, gestorHilos);
		
		lblContadorTotal = new JLabel("Contador Total: 0");
		lblContadorTotal.setFont(new Font(FONT, Font.PLAIN, 25));
		lblContadorTotal.setBounds(429, 52, 366, 30);
		contentPane.add(lblContadorTotal);
		
		JButton btnParar = new JButton("PARAR HILO");
		btnParar.setFont(new Font(FONT, Font.PLAIN, 14));
		btnParar.setBackground(SystemColor.control);
		btnParar.setBounds(34, 434, 161, 40);
		contentPane.add(btnParar);
		
		JButton btnPararTodos = new JButton("PARAR TODOS");
		btnPararTodos.setFont(new Font(FONT, Font.PLAIN, 14));
		btnPararTodos.setBackground(SystemColor.control);
		btnPararTodos.setBounds(205, 434, 161, 40);
		contentPane.add(btnPararTodos);
		
		JButton btnMostrarActivos = new JButton("MOSTRAR ACTIVOS");
		btnMostrarActivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorHilos.showList();
			}
		});
		btnMostrarActivos.setFont(new Font(FONT, Font.PLAIN, 14));
		btnMostrarActivos.setBackground(SystemColor.control);
		btnMostrarActivos.setBounds(617, 434, 161, 40);
		contentPane.add(btnMostrarActivos);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnLimpiar.setFont(new Font(FONT, Font.PLAIN, 14));
		btnLimpiar.setBackground(SystemColor.control);
		btnLimpiar.setBounds(439, 434, 161, 40);
		contentPane.add(btnLimpiar);
		
		btnLanzar.addActionListener(botonLanzarHilo);
		btnLanzarDefault.addActionListener(botonLanzarHiloDefault);
		btnParar.addActionListener(botonPararHilo);
		btnPararTodos.addActionListener(botonPararTodos);
		
		botonLanzarHilo.addBotonPresionadoListener(this);
		botonLanzarHiloDefault.addBotonPresionadoListener(this);
		tableModel.setEventListener(this);
	}

	@Override
	public void updateContadorHilo() {
	    lblContadorHilos.setText("Contador Hilos: " + tableModel.getRowCount());
	}


	@Override
	public void updateContadorTotal() {
		int contadorTotal = 0;
	    for (int i = 0; i < tableModel.getRowCount(); i++) {
	        if (tableModel.getValueAt(i, 1) != null) {
	        	contadorTotal += (int) tableModel.getValueAt(i, 1);
	        }
	    }
	    lblContadorTotal.setText("Contador Total: " + contadorTotal);
	}
}
