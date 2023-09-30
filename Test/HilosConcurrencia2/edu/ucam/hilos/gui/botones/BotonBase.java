package edu.ucam.hilos.gui.botones;

import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.gui.tabla.MiTabla;

public abstract class BotonBase {
	
	protected MiTabla tableModel;
    protected GestorHilos gestorHilos;

    protected BotonBase(MiTabla tableModel, GestorHilos gestorHilos) {
        this.tableModel = tableModel;
        this.gestorHilos = gestorHilos;
    }

}
