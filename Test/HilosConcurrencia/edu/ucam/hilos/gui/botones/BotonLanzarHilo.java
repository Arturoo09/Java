package edu.ucam.hilos.gui.botones;

import javax.swing.JTextField;
import edu.ucam.hilos.gui.tabla.MiTabla;


public class BotonLanzarHilo extends BotonLanzarBase {

    private JTextField txtDelay;
    private JTextField txtTimes;

    public BotonLanzarHilo(MiTabla tableModel, JTextField txtDelay, JTextField txtTimes) {
        super(tableModel);
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
        return Integer.parseInt(txtDelay.getText());
    }

    @Override
    protected int getTimes() {
        return Integer.parseInt(txtTimes.getText());
    }
}

