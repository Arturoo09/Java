package edu.ucam.hilossinarray.gui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import edu.ucam.hilossinarray.back.Hilo1;
import edu.ucam.hilossinarray.back.Hilo2;
import edu.ucam.hilossinarray.back.NombresHilos;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String FONTNAME = "Hack Nerd Font";
    private JPanel contentPane;
    
    private BotonEjecutarTodos bottonEjecutarTodos;
    private BotonParar botonParar;
    private JTextArea textArea;
    private BotonEjecutarUno botonEjecutarUno;
    
    private Hilo1 hilo1;
	private Hilo2 hilo2;
    
    public VentanaPrincipal() {
    	
    	botonParar = new BotonParar();
    	bottonEjecutarTodos = new BotonEjecutarTodos(hilo1, hilo2, botonParar);
    	
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 523, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnEjecutar = new JButton("EJECUTAR TODOS");
        btnEjecutar.setBounds(10, 297, 156, 59);
        contentPane.setLayout(null);
        btnEjecutar.setBackground(SystemColor.scrollbar);
        btnEjecutar.setFont(new Font(FONTNAME, Font.BOLD, 14));
        contentPane.add(btnEjecutar);
        
        JButton btnParar = new JButton("PARAR");
        btnParar.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnParar.setBackground(SystemColor.scrollbar);
        btnParar.setBounds(176, 297, 156, 59);
        contentPane.add(btnParar);
        
        JComboBox<String> comboBox = new JComboBox<>(NombresHilos.getNombreHilosArray());
        comboBox.setBounds(10, 11, 322, 32);
        contentPane.add(comboBox);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textArea.setText("");
        	}
        });
        btnLimpiar.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnLimpiar.setBackground(SystemColor.scrollbar);
        btnLimpiar.setBounds(341, 297, 156, 59);
        contentPane.add(btnLimpiar);
        
        JButton btnEjecutarUno = new JButton("EJECUTAR UNO");
        btnEjecutarUno.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnEjecutarUno.setBackground(SystemColor.scrollbar);
        btnEjecutarUno.setBounds(342, 11, 155, 32);
        contentPane.add(btnEjecutarUno);
        
        botonEjecutarUno = new BotonEjecutarUno(comboBox, hilo1, hilo2, botonParar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 54, 487, 232);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
        OutputTextArea outputTextArea = new OutputTextArea(textArea);
        PrintStream printStream = new PrintStream(outputTextArea);
        System.setOut(printStream);
        
        
        btnEjecutarUno.addActionListener(botonEjecutarUno);
        btnEjecutar.addActionListener(bottonEjecutarTodos);
        btnParar.addActionListener(botonParar);
    }
}
