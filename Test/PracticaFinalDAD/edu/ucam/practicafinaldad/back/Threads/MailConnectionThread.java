package edu.ucam.practicafinaldad.back.Threads;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class MailConnectionThread extends Thread{
	
	private String host;
	private int port;
	private String email;
	private String password;

    public MailConnectionThread(String host, int port, String email, String password) {
        this.email = email;
        this.password = password;
        this.host = host;
        this.port = port;
    }
	
	@Override
	public void run() {
		
		SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket sc = (SSLSocket) sslSocketFactory.createSocket(host, port)) {
            System.out.println("[OK]");
            System.out.println("Connecting to mail with IMAP using: " + email);
            
            InputStream inputStream = sc.getInputStream();
            OutputStream outputStream = sc.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Use a unique tag for the LOGIN command
            writer.println("A001 LOGIN " + this.email + " " + this.password);
            
            String response = reader.readLine();
            System.out.println("Login Response: " + response);

            // Successfully logged in
            System.out.println(response);

            // Use another unique tag for the SELECT command
            writer.println("A002 SELECT INBOX");
            response = reader.readLine();
            System.out.println("SELECT Response: " + response);

            // Fetch the list of message IDs (this example fetches the first 100 emails)
            writer.println("A003 FETCH 1:100 (UID BODY[HEADER])");
            String line;
            while (!(line = reader.readLine()).equals(")")) {
                System.out.println(line);
                // You would parse the email headers and details here.
                // Depending on the number of emails and their size, you might need to adjust this.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
