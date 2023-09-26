package tests;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIConHilos extends JFrame {
    private JButton lanzarHiloButton;
    private JTable hiloTable;
    private DefaultTableModel tableModel;
    private int hilosLanzados = 0;

    public GUIConHilos() {
        // Configura la ventana principal
        setTitle("Ejemplo de GUI con Hilos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura el botón para lanzar hilos
        lanzarHiloButton = new JButton("Lanzar Hilo");
        lanzarHiloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Incrementa el contador de hilos lanzados
                hilosLanzados++;

                // Crea un nuevo hilo
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            // Actualiza la tabla con el nombre del hilo y el contador
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    tableModel.addRow(new Object[]{Thread.currentThread().getName(), hilosLanzados});
                                }
                            });

                            // Simula alguna actividad del hilo
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });

                // Inicia el hilo
                hilo.start();
            }
        });

        // Configura la tabla
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre del Hilo");
        tableModel.addColumn("Contador");

        hiloTable = new JTable(tableModel);

        // Coloca la tabla dentro de un JScrollPane
        JScrollPane scrollPane = new JScrollPane(hiloTable);

        // Configura el diseño de la ventana
        setLayout(new BorderLayout());
        add(lanzarHiloButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUIConHilos gui = new GUIConHilos();
                gui.setVisible(true);
            }
        });
    }
}
