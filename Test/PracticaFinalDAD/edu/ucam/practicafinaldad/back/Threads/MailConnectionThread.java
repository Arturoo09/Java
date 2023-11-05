package edu.ucam.practicafinaldad.back.Threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import edu.ucam.practicafinaldad.back.Email;
import edu.ucam.practicafinaldad.back.MailConnections.IMAPConnection;
import edu.ucam.practicafinaldad.gui.Table.EmailTableModel;


public class MailConnectionThread extends Thread {

    private IMAPConnection imapConnection;
    private List<Email> emailList = new ArrayList<>();
    private EmailTableModel tableModel;
    private JProgressBar progressBar;
    private JLabel lblStatus;
    private int amount;

    public MailConnectionThread(IMAPConnection imapConnection, EmailTableModel tableModel, JProgressBar progressBar, JLabel lblStatus, int amount) {
        this.imapConnection = imapConnection;
        this.tableModel = tableModel;
        this.progressBar = progressBar;
        this.lblStatus = lblStatus;
        this.amount = amount;
    }

    private void addEmailToList(Email email) {
        this.emailList.add(email);
    }

    @Override
    public void run() {
        try {
            imapConnection.connect();
            System.out.println("Server Greeting: " + imapConnection.getGreeting());
            imapConnection.login(imapConnection.getEmail(), imapConnection.getPswdMail());
            lblStatus.setText("[*] LOGIN SUCCESSFUL");
            
            imapConnection.selectMailbox("INBOX");
            String[] emailIds = imapConnection.fetchEmailIDs();
            
            Collections.reverse(Arrays.asList(emailIds));

            int emailCount = Math.min(amount, emailIds.length);
            progressBar.setMinimum(0);
            progressBar.setMaximum(emailCount - 1); 
            progressBar.setValue(0);

            for (int i = 0; i < emailCount; i++) {
            	String emailId = emailIds[i];
                lblStatus.setText("[*] GETTING THE EMAILS...");

                String emailSubject = imapConnection.fetchEmailSubject(emailId);
                String emailBody = imapConnection.fetchEmailBody(emailId);

                Email email = new Email(emailId, emailSubject, emailBody);
                addEmailToList(email);
                SwingUtilities.invokeLater(() -> progressBar.setValue(progressBar.getValue() + 1));
            }

            tableModel.setData(this.emailList);
            
            imapConnection.logout();
            System.out.println("LOGOUT");
            lblStatus.setText("[*] LOGOUT");
            SwingUtilities.invokeLater(() -> progressBar.setValue(0));

            imapConnection.close();

        } catch (Exception e) {
            lblStatus.setText("HA SURGIDO UN ERROR EN LA CAPTURA DE EMAILS...");
            e.printStackTrace();
        }
    }
}
