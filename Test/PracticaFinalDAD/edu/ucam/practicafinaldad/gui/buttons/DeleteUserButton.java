package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.connectionDB.DatabaseManager;
import edu.ucam.practicafinaldad.gui.Table.UserTableModel;

public class DeleteUserButton implements ActionListener {
    
    private JTable table;
    private DatabaseManager dbManager;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JCheckBox chkbxIsAdmin;
    
    public DeleteUserButton(JTable table, JTextField txtUsername, JTextField txtPassword, JCheckBox chkbxIsAdmin) {
        this.table = table;
        this.txtUsername = txtUsername;
        this.txtPassword = txtPassword;
        this.chkbxIsAdmin = chkbxIsAdmin;
        try {
            this.dbManager = new DatabaseManager();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        if(row == -1) {
            // Mostrar algún mensaje de error al usuario
            return;
        }
        
        String id = (String) table.getValueAt(row, 0); // Asumiendo que el ID está en la columna 0
        
        try {
            dbManager.delete("users", "id = " + id);
            ((UserTableModel) table.getModel()).removeRow(row); // Asegúrate de que tu modelo de tabla tenga un método removeRow
            
            txtUsername.setText("");
            txtPassword.setText("");
            chkbxIsAdmin.setSelected(false);
            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
