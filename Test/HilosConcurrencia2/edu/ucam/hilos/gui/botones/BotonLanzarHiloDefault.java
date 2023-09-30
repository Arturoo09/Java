package edu.ucam.hilos.gui.botones;

import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.gui.tabla.MiTabla;

public class BotonLanzarHiloDefault extends BotonLanzarBase {

    private static final int DEFAULT_DELAY = 75;
    private static final int DEFAULT_TIMES = 100;

    public BotonLanzarHiloDefault(MiTabla tableModel, GestorHilos gestorHilos) {
        super(tableModel, gestorHilos);
    }

    @Override
    protected int getDelay() {
        return DEFAULT_DELAY;
    }

    @Override
    protected int getTimes() {
        return DEFAULT_TIMES;
    }
}
