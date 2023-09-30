package edu.ucam.hilos.gui.tabla;

import edu.ucam.hilos.back.HiloSimple;

public interface ListaHilosObserver {
	void hiloRegistrado(HiloSimple hilo, int contador);
	void hiloEliminado(HiloSimple hilo);
	void todosHilosEliminados();
}
