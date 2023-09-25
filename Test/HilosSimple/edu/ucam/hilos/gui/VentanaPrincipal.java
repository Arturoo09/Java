package edu.ucam.hilos.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import edu.ucam.hilos.back.NombreHilos;

import java.awt.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String FONTNAME = "Hack Nerd Font";
    private JPanel contentPane;
    
    private ButtonEjecutar buttonEjecutar;
    private ButtonPara buttonParar;
    private JTextArea textArea;
    private ButtonEjecutarUno buttonEjecutarUno;
    private ButtonPararUno buttonPararUno;
    
    private List<Thread> hilos = new ArrayList<>();
    
    public VentanaPrincipal() {
    	
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 523, 505);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnEjecutar = new JButton("EJECUTAR TODOS");
        btnEjecutar.setBounds(10, 396, 156, 59);
        contentPane.setLayout(null);
        btnEjecutar.setBackground(SystemColor.scrollbar);
        btnEjecutar.setFont(new Font(FONTNAME, Font.BOLD, 14));
        contentPane.add(btnEjecutar);
        
        JButton btnParar = new JButton("PARAR");
        btnParar.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnParar.setBackground(SystemColor.scrollbar);
        btnParar.setBounds(176, 396, 156, 59);
        contentPane.add(btnParar);
        
        JComboBox<String> comboBox = new JComboBox<>(NombreHilos.getNombreHilosArray());
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
        btnLimpiar.setBounds(341, 396, 156, 25);
        contentPane.add(btnLimpiar);
        
        JButton btnEjecutarUno = new JButton("EJECUTAR UNO");
        btnEjecutarUno.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnEjecutarUno.setBackground(SystemColor.scrollbar);
        btnEjecutarUno.setBounds(342, 10, 155, 32);
        contentPane.add(btnEjecutarUno);
        
        JButton btnArray = new JButton("Mostrar Array");
        btnArray.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (hilos.isEmpty())
        			System.out.println("Array empty");
        		
        		for (Thread thread : hilos) {
					System.out.println(thread);
				}
        	}
        });
        btnArray.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnArray.setBackground(SystemColor.scrollbar);
        btnArray.setBounds(341, 430, 156, 25);
        contentPane.add(btnArray);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 96, 487, 289);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
        OutputTextArea outputTextArea = new OutputTextArea(textArea);
        
        JButton btnPararHilosArray = new JButton("PARAR HILO");
        btnPararHilosArray.setFont(new Font(FONTNAME, Font.BOLD, 14));
        btnPararHilosArray.setBackground(SystemColor.scrollbar);
        btnPararHilosArray.setBounds(341, 53, 155, 32);
        contentPane.add(btnPararHilosArray);
        
        JComboBox<Thread> comboBox_1 = new JComboBox<>();
        comboBox_1.setBounds(10, 54, 322, 31);
        contentPane.add(comboBox_1);
        
        
        PrintStream printStream = new PrintStream(outputTextArea);
        System.setOut(printStream);
        
        buttonEjecutar = new ButtonEjecutar(hilos, comboBox_1);
    	buttonParar = new ButtonPara(hilos, comboBox_1);
    	buttonEjecutarUno = new ButtonEjecutarUno(comboBox, hilos, comboBox_1);
    	buttonPararUno = new ButtonPararUno(comboBox_1);
    	
        
        btnEjecutarUno.addActionListener(buttonEjecutarUno);
        btnEjecutar.addActionListener(buttonEjecutar);
        btnParar.addActionListener(buttonParar);
        btnPararHilosArray.addActionListener(buttonPararUno);
    }
}