package edu.ucam.practicafinaldad.gui.Table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import edu.ucam.practicafinaldad.back.User;

public class UserTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
    private final String[] columnNames = {"ID", "Username", "Password", "Is Admin"};
    
    private List<User> data;

    public UserTableModel(List<User> data) {
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
        User user = data.get(row);
        switch (col) {
            case 0:
                return user.getId();
            case 1:
                return user.getUsername();
            case 2:
                return user.getPassword();
            case 3:
                return user.getAdmin();
            default:
                throw new IllegalArgumentException("Column index out of range");
        }
    }

    public User getUserAt(int row) {
        return data.get(row);
    }

    public void setData(List<User> data) {
        this.data = data;
        fireTableDataChanged();
    }
    
    // Método para eliminar una fila
    public void removeRow(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    // Método para actualizar una fila
    public void updateRow(int row, User user) {
        data.set(row, user);
        fireTableRowsUpdated(row, row);
    }
    
    // Método para añadir una fila
    public void addData(User user) {
        data.add(user);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    // Opcional: sobrescribir este método si quieres que la columna de 'Is Admin' muestre checkboxes
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 3 ? Boolean.class : String.class;
    }

    // Opcional: sobrescribir este método si quieres que las celdas no sean editables
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
