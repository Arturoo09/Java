package edu.ucam.hilos.gui.botones;

import javax.swing.JTextField;
import edu.ucam.hilos.back.GestorHilos;
import edu.ucam.hilos.gui.tabla.MiTabla;


public class BotonLanzarHilo extends BotonLanzarBase {

    private JTextField txtDelay;
    private JTextField txtTimes;

    public BotonLanzarHilo(MiTabla tableModel, GestorHilos gestorHilos, JTextField txtDelay, JTextField txtTimes) {
        super(tableModel, gestorHilos);
        this.txtDelay = txtDelay;
        this.txtTimes = txtTimes;
    }
    
    @Override
    protected void postAction() {
        txtDelay.setText("");
        txtTimes.setText("");
    }
    
    @Override
    protected int getDelay() {
    	try {
    		return Integer.parseInt(txtDelay.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
    }

    @Override
    protected int getTimes() {
        try {
        	return Integer.parseInt(txtTimes.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
    }
}

