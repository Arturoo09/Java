package edu.ucam.hilos.gui.botones;

import edu.ucam.hilos.gui.tabla.MiTabla;

public class BotonLanzarHiloDefault extends BotonLanzarBase {

    private static final int DEFAULT_DELAY = 250;
    private static final int DEFAULT_TIMES = 10000;

    public BotonLanzarHiloDefault(MiTabla tableModel) {
        super(tableModel);
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
