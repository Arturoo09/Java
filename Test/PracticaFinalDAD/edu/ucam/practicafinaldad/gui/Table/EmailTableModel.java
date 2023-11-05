package edu.ucam.practicafinaldad.gui.Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.ucam.practicafinaldad.back.Email;

public class EmailTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private final String[] columnNames = {"Email Subject"};
    
	private List<Email> data;

    public EmailTableModel(List<Email> data) {
        this.data = data;
    }
	
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Email email = data.get(row);
        return email.getSubject();
    }

    public Email getEmailAt(int row) {
        return data.get(row);
    }

    public void setData(List<Email> data) {
        this.data = data;
        fireTableDataChanged();
    }

}
