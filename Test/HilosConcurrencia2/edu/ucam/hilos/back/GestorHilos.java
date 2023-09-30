package edu.ucam.hilos.back;

import java.util.ArrayList;
import java.util.List;

import edu.ucam.hilos.gui.EventListener;
import edu.ucam.hilos.gui.tabla.ListaHilosObserver;

public class GestorHilos {

    private List<HiloSimple> hilosActivos = new ArrayList<>();
    private List<ListaHilosObserver> observers = new ArrayList<>();
    
	private EventListener eventListener;

    public void setEventListener(EventListener listener) {
        this.eventListener = listener;
    }
    
    public HiloSimple getHiloAt(int index) {
        return hilosActivos.get(index);
    }
    
    public void addHilo(HiloSimple hilo, int contador) {
        hilosActivos.add(hilo);
        notifyHiloAnadido(hilo, contador);
    }
    
    public void detenerHilo(HiloSimple hilo) {
    	hilo.interrupt();
    	hilosActivos.remove(hilo);
    	notifyHiloEliminado(hilo);
    	
    	if (eventListener != null) {
            eventListener.updateContadorHilo();
            eventListener.updateContadorTotal();
        }
    }
    
    public void detenerTodos() {
        for (HiloSimple hilo : hilosActivos) {
            hilo.interrupt();
        }
        hilosActivos.clear();
        notifyTodosHilosEliminados();
        
        if (eventListener != null) {
            eventListener.updateContadorHilo();
            eventListener.updateContadorTotal();
        }
    }
    
    public void showList() {
    	if (hilosActivos.isEmpty()) {
    		System.out.println("Array empty");
    	}
		
		for (Thread thread : hilosActivos) {
			System.out.println(thread);
		}
    }

    private void notifyHiloAnadido(HiloSimple hilo, int contador) {
        for (ListaHilosObserver observer : observers) {
            observer.hiloRegistrado(hilo, contador);
        }
    }
    
    private void notifyHiloEliminado(HiloSimple hilo) {
        for (ListaHilosObserver observer : observers) {
            observer.hiloEliminado(hilo);
        }
    }
    
    private void notifyTodosHilosEliminados() {
        for (ListaHilosObserver observer : observers) {
            observer.todosHilosEliminados();
        }
    }

    public void registerObserver(ListaHilosObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ListaHilosObserver observer) {
        observers.remove(observer);
    }
    
}

