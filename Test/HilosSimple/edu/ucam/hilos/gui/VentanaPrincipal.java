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
    
    private List<Thread> hilos = new ArrayList<>();
    
    public VentanaPrincipal() {
    	
    	buttonEjecutar = new ButtonEjecutar(hilos);
    	buttonParar = new ButtonPara(hilos);
    	
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
        
        textArea = new JTextArea();
        textArea.setBounds(10, 54, 487, 232);
        contentPane.add(textArea);
        
        JComboBox<String> comboBox = new JComboBox<>(NombreHilos.getNombreHilosArray());
        comboBox.setBounds(10, 11, 322, 32);
        contentPane.add(comboBox);
        
        OutputTextArea outputTextArea = new OutputTextArea(textArea);
        
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
        
        PrintStream printStream = new PrintStream(outputTextArea);
        System.setOut(printStream);
        
        buttonEjecutarUno = new ButtonEjecutarUno(comboBox, hilos);
        
        
        btnEjecutarUno.addActionListener(buttonEjecutarUno);
        btnEjecutar.addActionListener(buttonEjecutar);
        btnParar.addActionListener(buttonParar);
    }
}