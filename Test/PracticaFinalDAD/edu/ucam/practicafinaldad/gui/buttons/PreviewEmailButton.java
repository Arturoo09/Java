package edu.ucam.practicafinaldad.gui.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import edu.ucam.practicafinaldad.back.Email;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;

public class PreviewEmailButton implements ActionListener {
    private final JTable emailTable;
    private final EmailTableModel tableModel;

    public PreviewEmailButton(JTable emailTable, EmailTableModel tableModel) {
        this.emailTable = emailTable;
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = emailTable.getSelectedRow();
        if (selectedRow >= 0) {
            Email selectedEmail = tableModel.getEmailAt(selectedRow);
            if (selectedEmail != null) {
                showEmailDialog(selectedEmail);
            }
        }
    }

    private void showEmailDialog(Email email) {
        JTextArea textArea = new JTextArea(10, 40);
        textArea.setText("Subject: " + email.getSubject() + "\n\n" + email.getBody());
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Email Details", JOptionPane.INFORMATION_MESSAGE);
    }
}


