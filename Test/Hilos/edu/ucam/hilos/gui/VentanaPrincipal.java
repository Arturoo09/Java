package edu.ucam.hilos.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public VentanaPrincipal() {
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 254, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JButton btnEjecutar = new JButton("EJECUTAR");
        btnEjecutar.setBackground(SystemColor.scrollbar);
        btnEjecutar.setFont(new Font("Hack Nerd Font", Font.BOLD, 14));
        contentPane.add(btnEjecutar, BorderLayout.CENTER);

        btnEjecutar.addActionListener(new ButtonEjecutar());
    }
}