package edu.ucam.hilos.gui.botones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.ucam.hilos.back.Contador;
import edu.ucam.hilos.back.HiloSimple;
import edu.ucam.hilos.gui.EventListener;
import edu.ucam.hilos.gui.tabla.MiTabla;

public abstract class BotonLanzarBase implements ActionListener {

    protected List<EventListener> listeners = new ArrayList<>();
    protected MiTabla tableModel;

    protected BotonLanzarBase(MiTabla tableModel) {
        this.tableModel = tableModel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Contador contador = new Contador();
        
        tableModel.addHilo("Hilo-" + (tableModel.getRowCount() + 1), contador.getContador());
        int rowIndex = tableModel.getRowCount() - 1;
        
        int delay = getDelay();
        int times = getTimes();
        
        HiloSimple hilo = new HiloSimple(delay, times, contador, tableModel, rowIndex);
        hilo.start();
        
        botonPresionadoEvent();
        postAction();
    }
    
    protected void postAction() {}

    protected abstract int getDelay();
    
    protected abstract int getTimes();

    public void addBotonPresionadoListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeBotonPresionadoListener(EventListener listener) {
        listeners.remove(listener);
    }
    
    private void botonPresionadoEvent() {
        for (EventListener listener : listeners) {
            listener.updateContadorHilo();
        }
    }
}
