package edu.ucam.hilos.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonPara implements ActionListener {
    private List<Thread> hilos;

    public ButtonPara(List<Thread> hilos) {
        this.hilos = hilos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (Thread hilo : hilos) {
                hilo.interrupt();
            }
        } catch (Exception e1) {
            System.out.println("Error...");
        }
    }
}

