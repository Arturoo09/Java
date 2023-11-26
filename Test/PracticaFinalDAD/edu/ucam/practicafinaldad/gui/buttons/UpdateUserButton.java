package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.ucam.practicafinaldad.back.User;
import edu.ucam.practicafinaldad.back.connectionDB.MySQL.DatabaseManager;
import edu.ucam.practicafinaldad.gui.Table.UserTableModel;

public class UpdateUserButton implements ActionListener {
    
    private JTable table;
    private DatabaseManager dbManager;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JCheckBox chkbxIsAdmin;
    
    public UpdateUserButton(JTable table, JTextField txtUsername, JTextField txtPassword, JCheckBox chkbxIsAdmin) {
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
        
        String  id = (String) table.getValueAt(row, 0); // Asumiendo que el ID está en la columna 0
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        int isAdmin = chkbxIsAdmin.isSelected() ? 1 : 0;
        
        String setValues = "username = ?, password = ?, admin = ?";
        String whereCondition = "id = " + id;
        
        try {
            PreparedStatement statement = dbManager.getConnection().prepareStatement("UPDATE users SET " + setValues + " WHERE " + whereCondition);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, isAdmin);
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows > 0) {
                ((UserTableModel) table.getModel()).updateRow(row, new User(id, username, password, isAdmin == 1)); // Necesitarás implementar updateRow en EmailTableModel
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}